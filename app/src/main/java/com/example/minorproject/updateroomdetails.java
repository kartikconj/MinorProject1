package com.example.minorproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class updateroomdetails extends AppCompatActivity {
    String days,i1,sends,classes,rooms;
    Spinner day1,time1,class1;
    Button b1;
    EditText roomname;
    DatabaseReference d1= FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateroomdetails);
        b1=findViewById(R.id.button16);
        roomname=findViewById(R.id.editText8);
        day1=findViewById(R.id.spinner);
        time1=findViewById(R.id.spinner21);
        class1=findViewById(R.id.spinner22);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callupdater();
            }
        });

    }
    void callupdater()
    {   i1=time1.getSelectedItem().toString();
        days=day1.getSelectedItem().toString();
        if(i1.equals("8:30-9:30"))
        {
            sends="a";
        }
        else if(i1.equals("9:30-10:30"))
        {
            sends="b";
        }
        else if(i1.equals("10:30-11:30"))
        {
            sends="c";
        }
        else if(i1.equals("11:30-12:30"))
        {
            sends="d";
        }
        else if(i1.equals("12:30-1:30"))
        {
            sends="e";
        }
        else if(i1.equals("1:30-2:30"))
        {
            sends="f";
        }
        else if(i1.equals("2:30-3:30"))
        {
            sends="g";
        }
        else if(i1.equals("3:30-4:30"))
        {
            sends="h";
        }
        else if(i1.equals("4:30-5:30"))
        {
            sends="i";
        }
        else
        {
            sends="j";
        }
        rooms=roomname.getText().toString();
        classes=class1.getSelectedItem().toString();
        if(!TextUtils.isEmpty(rooms)) {
            d1.child(days).child(rooms).child(sends).setValue(classes);
        }
        else
        {
            Toast.makeText(this, "enter room number", Toast.LENGTH_LONG).show();
        }
    }
}
