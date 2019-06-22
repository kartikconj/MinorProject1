package com.example.minorproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class facultyviewtimetable extends AppCompatActivity {
    DatabaseReference d1;
    ArrayAdapter<String> arrayAdapter;
    Spinner s1;
    ListView displaytime1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facultyviewtimetable);
        FirebaseApp.initializeApp(this);
        displaytime1=findViewById(R.id.facultyview);
        Intent i1=getIntent();
        String name=i1.getStringExtra(dayselector.NAME);
        String day=i1.getStringExtra(dayselector.DAY);
        d1= FirebaseDatabase.getInstance().getReference().child("teacher").child(name).child(day);
        d1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                List<String> timings1 = new ArrayList<>();
                for(DataSnapshot ds1:dataSnapshot.getChildren()) {
                    timings1.add(ds1.getValue(String.class));
                }
                arrayAdapter= new ArrayAdapter<String>(facultyviewtimetable.this, android.R.layout.simple_list_item_1,timings1);
                displaytime1.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
