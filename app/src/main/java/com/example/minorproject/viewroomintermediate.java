package com.example.minorproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class viewroomintermediate extends AppCompatActivity {
    public static final String ROOMNAME="com.example.minor.ROOMNAME";
    public static final String DAY="com.example.minor.DAY";
    EditText e1;
    Spinner s1;
    Button a21;
    String day, rname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewroomintermediate);
        e1=findViewById(R.id.editText9);
        s1=findViewById(R.id.spinner23);
        a21=findViewById(R.id.button19);
        a21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callactualview();
            }
        });
    }
    void callactualview()
    {   rname=e1.getText().toString();
        day=s1.getSelectedItem().toString();
        if(!TextUtils.isEmpty(rname)) {
            Intent i = new Intent(this, ViewRoomData.class);
            i.putExtra(ROOMNAME, rname);
            i.putExtra(DAY, day);
            startActivity(i);
        }
        else{
            Toast.makeText(this, "Enter Room Name", Toast.LENGTH_SHORT).show();
        }

    }
}
