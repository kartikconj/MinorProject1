package com.example.minorproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewRoomData extends AppCompatActivity {
    ListView l1;
    ArrayAdapter<String> arrayAdapter;
    DatabaseReference d1;
    String roomname;
    String days;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_room_data);
        Intent i1=getIntent();
        roomname=i1.getStringExtra(viewroomintermediate.ROOMNAME);
        days=i1.getStringExtra(viewroomintermediate.DAY);
        l1=findViewById(R.id.rooms);
        d1= FirebaseDatabase.getInstance().getReference().child(days).child(roomname);
        d1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<String> roomdata = new ArrayList<>();
                for(DataSnapshot ds1:dataSnapshot.getChildren()) {
                    roomdata.add(ds1.getValue(String.class));
                }
                arrayAdapter= new ArrayAdapter<String>(ViewRoomData.this, android.R.layout.simple_list_item_1,roomdata);
                l1.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
