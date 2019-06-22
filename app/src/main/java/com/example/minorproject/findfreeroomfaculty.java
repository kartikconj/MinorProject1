package com.example.minorproject;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class findfreeroomfaculty extends AppCompatActivity {
    Spinner day,time;
    int total;
    Button b1;
    TextView t1;
    String rooname;
    List<String> firstlist=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findfreeroomfaculty);
        day=findViewById(R.id.spinner55);
        time=findViewById(R.id.spinner20);
        t1=findViewById(R.id.textView55);
        b1=findViewById(R.id.button14);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findrooms();
            }
        });
    }
    void findrooms()
    {   final String timestring1;
        String day1= day.getSelectedItem().toString();
        final String time1=time.getSelectedItem().toString();
        if (time1.equals("8:30-9:30")) {
            timestring1 = "a";
        } else if (time1.equals("9:30-10:30")) {
            timestring1 = "b";

        } else if (time1.equals("10:30-11:30")) {
            timestring1 = "c";

        } else if (time1.equals("11:30-12:30")) {
            timestring1 = "d";

        } else if (time1.equals("12:30-1:30")) {
            timestring1 = "e";

        } else if (time1.equals("1:30-2:30")) {
            timestring1 = "f";

        } else if (time1.equals("2:30-3:30")) {
            timestring1 = "g";

        } else if (time1.equals("3:30-4:30")) {
            timestring1 = "h";

        } else if (time1.equals("4:30-5:30")) {
            timestring1 = "i";

        } else {
            timestring1 = "j";
        }

        final DatabaseReference d1= FirebaseDatabase.getInstance().getReference().child(day1);
        final DatabaseReference d2=FirebaseDatabase.getInstance().getReference().child("room");
        d2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot ds:dataSnapshot.getChildren()) {
                    firstlist.add(ds.getValue(String.class));
                    total=firstlist.size();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        d1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (int i=0;i<total;i++) {
                    String abc = dataSnapshot.child(firstlist.get(i)).child(timestring1).getValue().toString();
                    if(abc.equals("no class"))
                    {
                        rooname=firstlist.get(i);
                        t1.setText("Room No. "+rooname+" is free");
                       break;
                    }
                    else
                    {
                        t1.setText("no room free");
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
