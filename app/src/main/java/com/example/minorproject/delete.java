package com.example.minorproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class delete extends AppCompatActivity {
    DatabaseReference database;
    EditText e1;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        e1=findViewById(R.id.editText3);
        b1=findViewById(R.id.button5);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });
    }
    void delete()
    {   String name=e1.getText().toString();
        if(!TextUtils.isEmpty(name)) {
            database = FirebaseDatabase.getInstance().getReference("teacher");
            database.child(name).removeValue();
            Toast.makeText(this, "Entry Deleted", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Insert Name", Toast.LENGTH_LONG).show();
        }
    }
}
