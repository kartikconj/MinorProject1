package com.example.minorproject;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class insertroom extends AppCompatActivity {
    Spinner spinner0, spinner, spinner1, spinner2, spinner3, spinner4, spinner5, spinner6, spinner7, spinner8, spinner9;
    Button b1;
    EditText e1;
    long maxint;
    DatabaseReference d1= FirebaseDatabase.getInstance().getReference();
    DatabaseReference d2= FirebaseDatabase.getInstance().getReference("room");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertroom);
        e1= findViewById(R.id.edittextin);
        spinner0=findViewById(R.id.spinner1);
        spinner=findViewById(R.id.spinner2);
        spinner1=findViewById(R.id.spinner3);
        spinner2=findViewById(R.id.spinner4);
        spinner3=findViewById(R.id.spinner5);
        spinner4=findViewById(R.id.spinner6);
        spinner5=findViewById(R.id.spinner7);
        spinner6=findViewById(R.id.spinner8);
        spinner7=findViewById(R.id.spinner9);
        spinner8=findViewById(R.id.spinner10);
        spinner9=findViewById(R.id.spinner11);
        b1=findViewById(R.id.button12);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addrooms();
            }
        });
        d2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               maxint=dataSnapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    void addrooms()
    {


        String roomname=e1.getText().toString();
        String day=spinner0.getSelectedItem().toString();
        String a=spinner.getSelectedItem().toString();
        String b=spinner1.getSelectedItem().toString();
        String c=spinner2.getSelectedItem().toString();
        String d=spinner3.getSelectedItem().toString();
        String e=spinner4.getSelectedItem().toString();
        String f=spinner5.getSelectedItem().toString();
        String g=spinner6.getSelectedItem().toString();
        String h=spinner7.getSelectedItem().toString();
        String i=spinner8.getSelectedItem().toString();
        String j=spinner9.getSelectedItem().toString();
        if(!TextUtils.isEmpty(roomname))
        {
            room room= new room(a,b,c,d,e,f,g,h,i,j);
            d1.child(day).child(roomname).setValue(room);
            if(day.equals("monday")) {
                d2.child(String.valueOf(maxint + 1)).setValue(roomname);
            }
            Toast.makeText(this,
                    "added", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Insert Name", Toast.LENGTH_LONG).show();
        }

    }

}
