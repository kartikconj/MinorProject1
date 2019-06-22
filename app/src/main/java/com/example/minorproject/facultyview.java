package com.example.minorproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.minorproject.MainActivity.USERNAME;

public class facultyview extends AppCompatActivity {
    public static final String USERNAME1="com.example.USERNAME1";
    TextView t1;
    Button b1,b2,b3;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facultyview);
        Intent i=getIntent();
        name=i.getStringExtra(MainActivity.USERNAME);
        t1=findViewById(R.id.textView35);
        t1.setText("Welcome "+ name);
        b1=findViewById(R.id.button6);
        b2=findViewById(R.id.button7);
        b3=findViewById(R.id.button13);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callview();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callfindfreeslot();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findfacultyroom();
            }
        });

    }

    void callview()
    {
        Intent i1=new Intent(this, dayselector.class);
                i1.putExtra(USERNAME1,name);
                startActivity(i1);
    }
    void callfindfreeslot()
    {
        Intent i1=new Intent(this, facultyfreeslots.class);
        startActivity(i1);
    }
    void findfacultyroom()
    {
        Intent i1=new Intent(this, findfreeroomfaculty.class);
        startActivity(i1);
    }

}
