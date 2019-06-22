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

public class registernewuser extends AppCompatActivity {
    EditText id1, pass;
    Spinner aut;
    Button b1;
    String name, password, auth;
    DatabaseReference d1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registernewuser);
        d1= FirebaseDatabase.getInstance().getReference("view");
        id1=findViewById(R.id.editText6);
        pass=findViewById(R.id.editText7);
        b1=findViewById(R.id.button11);
        aut=findViewById(R.id.spinner17);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adddata();
            }
        });
    }
    void adddata()
    {
        name=id1.getText().toString();
        password=pass.getText().toString();
        auth=aut.getSelectedItem().toString();

        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password))
        {
            register r1 = new register(name, password, auth);
            d1.child(name).setValue(r1);
            Toast.makeText(this, "Registered", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, "Enter Data ", Toast.LENGTH_LONG).show();
        }
    }
}
