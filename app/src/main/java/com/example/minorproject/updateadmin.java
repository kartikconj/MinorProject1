package com.example.minorproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class updateadmin extends AppCompatActivity {
    DatabaseReference database;
    Spinner s1,s2,s3;
    EditText e1;
    Button b1;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateadmin);
        s1=findViewById(R.id.spinner13);
        s2=findViewById(R.id.spinner14);
        e1=findViewById(R.id.editText2);
        s3=findViewById(R.id.spinner15);
        b1=findViewById(R.id.button4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callupdate();
            }
        });

    }
    void callupdate()
    { String name=e1.getText().toString();
      String i1= s1.getSelectedItem().toString();
      String day=s3.getSelectedItem().toString();
      String classselector=s2.getSelectedItem().toString();

      String send;
        if(i1.equals("8:30-9:30"))
        {
            send="a";
        }
        else if(i1.equals("9:30-10:30"))
        {
            send="b";
        }
        else if(i1.equals("10:30-11:30"))
        {
            send="c";
        }
        else if(i1.equals("11:30-12:30"))
        {
            send="d";
        }
        else if(i1.equals("12:30-1:30"))
        {
            send="e";
        }
        else if(i1.equals("1:30-2:30"))
        {
            send="f";
        }
        else if(i1.equals("2:30-3:30"))
        {
            send="g";
        }
        else if(i1.equals("3:30-4:30"))
        {
            send="h";
        }
        else if(i1.equals("4:30-5:30"))
        {
            send="i";
        }
        else
        {
            send="j";
        }
        if(!TextUtils.isEmpty(name)) {
        database = FirebaseDatabase.getInstance().getReference("teacher").child(name).child(day).child(send);
        database.setValue(classselector);
        Toast.makeText(this,"Updated", Toast.LENGTH_LONG).show();
    }
    else
        {
            Toast.makeText(this,"Insert Name", Toast.LENGTH_LONG).show();
        }

    }

}
