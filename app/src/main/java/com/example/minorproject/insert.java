package com.example.minorproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class insert extends AppCompatActivity {

    EditText name;
    Button btn;
    Spinner spinner0, spinner, spinner1, spinner2, spinner3, spinner4, spinner5, spinner6, spinner7, spinner8, spinner9;
        DatabaseReference databaseartist=FirebaseDatabase.getInstance().getReference("teacher");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        name= findViewById(R.id.name);
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
        btn=findViewById(R.id.button2);
        FirebaseApp.initializeApp(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addteacher();
            }
        });
    }
    private void addteacher()

    {   String a,b,c,d,e,f,g,h,i,j;
        String day;
        String tname=name.getText().toString().toLowerCase().trim();
        day=spinner0.getSelectedItem().toString().trim();
        a=spinner.getSelectedItem().toString();
        b=spinner1.getSelectedItem().toString();
        c=spinner2.getSelectedItem().toString();
        d=spinner3.getSelectedItem().toString();
        e=spinner4.getSelectedItem().toString();
        f=spinner5.getSelectedItem().toString();
        g=spinner6.getSelectedItem().toString();
        h=spinner7.getSelectedItem().toString();
        i=spinner8.getSelectedItem().toString();
        j=spinner9.getSelectedItem().toString();
        if(!TextUtils.isEmpty(tname))
        {
            Teacher teacher= new Teacher(a,b,c,d,e,f,g,h,i,j);
            databaseartist.child(tname).child(day).setValue(teacher);
            Toast.makeText(this, "added", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Insert Name", Toast.LENGTH_LONG).show();
        }


    }
}
