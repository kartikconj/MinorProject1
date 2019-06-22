package com.example.minorproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class viewingitems extends AppCompatActivity {
    ListView displaytime;
    TextView t2;
    DatabaseReference database;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewingitems);
        t2=(TextView)findViewById(R.id.textView19);
        displaytime=(ListView)findViewById(R.id.time);
        Intent i=getIntent();
        String name=i.getStringExtra(viewadmin.TNAME);
        String day=i.getStringExtra(viewadmin.DAY);
        t2.setText(name);
        database= FirebaseDatabase.getInstance().getReference().child("teacher").child(name).child(day);
        FirebaseApp.initializeApp(this);
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<String> timings = new ArrayList<>();
                for(DataSnapshot ds:dataSnapshot.getChildren()) {
                    timings.add(ds.getValue(String.class));
                }
                arrayAdapter= new ArrayAdapter<String>(viewingitems.this, android.R.layout.simple_list_item_1,timings);
                displaytime.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }




}
