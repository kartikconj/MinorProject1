package com.example.minorproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class dayselector extends AppCompatActivity {
    public static final String DAY="com.example.minor.day";
    public static final String NAME="com.example.minor.name";
    Spinner s1;
    Button b1;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dayselector);
        Intent i=getIntent();
        name=i.getStringExtra(facultyview.USERNAME1);
        s1=findViewById(R.id.spinner16);
        b1=findViewById(R.id.button8);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            callfaculty();
            }
        });
    }
    void callfaculty()
    {
        String day=s1.getSelectedItem().toString();
        Intent finallyshow= new Intent(this, facultyviewtimetable.class);
        finallyshow.putExtra(DAY,day);
        finallyshow.putExtra(NAME, name);
        startActivity(finallyshow);

    }
}
