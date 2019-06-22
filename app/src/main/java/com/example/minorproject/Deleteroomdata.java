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

public class Deleteroomdata extends AppCompatActivity {
    Button b11;
    Spinner s1;
    EditText e1;
    String names,days;
    DatabaseReference d1,d2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleteroomdata);
        e1=findViewById(R.id.editText10);
        s1=findViewById(R.id.spinner24);
        b11=findViewById(R.id.button20);
        d1= FirebaseDatabase.getInstance().getReference();
        d2= FirebaseDatabase.getInstance().getReference("room");
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleting();
            }
        });
    }
    void deleting()
    {
        names=e1.getText().toString().trim();
        days=s1.getSelectedItem().toString().trim();
        d1=d1.child(days).child(names);
        if(!TextUtils.isEmpty(names))
        {
            d1.removeValue();
            d2.child(names).removeValue();
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "enter room name", Toast.LENGTH_SHORT).show();
        }

    }
}
