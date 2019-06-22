package com.example.minorproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class selector extends AppCompatActivity {
    Button insert;
    Button b2,b3,b4,b5,b6,b7,b8,b9;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i=getIntent();
        String message = i.getStringExtra(MainActivity.USERNAME);
        setContentView(R.layout.activity_selector);
        t1=findViewById(R.id.messagedisplay);
        t1.setText("Welcome "+message);
        insert=(Button) findViewById(R.id.insert);
        b2=findViewById(R.id.view);
        b3=findViewById(R.id.update);
        b4=findViewById(R.id.delete);
        b5=findViewById(R.id.button10);
        b6=findViewById(R.id.insertroom);
        b7=findViewById(R.id.button15);
        b8=findViewById(R.id.button17);
        b9=findViewById(R.id.button18);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callview();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callupdate();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteitem();
            }
        });
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callinsert();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callregister();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertroom();
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updaterooms();
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callviewroom();
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calldeleteroom();
            }
        });
    }
    void callinsert()
    {
        Intent callinsert1= new Intent(this, insert.class);
        startActivity(callinsert1);
    }
    void callview()
    {
        Intent calladminview= new Intent(this, viewadmin.class);
        startActivity(calladminview);
    }
    void callupdate()
    {
        Intent callupdate1= new Intent(this, updateadmin.class);
        startActivity(callupdate1);
    }
    void deleteitem()
    {
        Intent calldelete= new Intent(this, delete.class);
        startActivity(calldelete);
    }
    void callregister()
    {
        Intent callnew= new Intent(this, registernewuser.class);
        startActivity(callnew);
    }
    void insertroom()
    {
        Intent callroom= new Intent(this, insertroom.class);
        startActivity(callroom);
    }
    void updaterooms()
    {
        Intent room= new Intent(this, updateroomdetails.class);
        startActivity(room);
    }
    void callviewroom()
    {
        Intent room= new Intent(this, viewroomintermediate.class);
        startActivity(room);
    }

    void calldeleteroom()
    {
        Intent room= new Intent(this, Deleteroomdata.class);
        startActivity(room);
    }
}

