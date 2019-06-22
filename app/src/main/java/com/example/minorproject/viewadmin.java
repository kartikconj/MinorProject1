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

public class viewadmin extends AppCompatActivity {
    Button b1;
    EditText names;
    Spinner s1;
    public static final String DAY="com.example.minorproject.day";
    public static final String TNAME="com.example.minorproject.username";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewadmin);
        s1=findViewById(R.id.spinner12);
        names=findViewById(R.id.editText);
        b1=findViewById(R.id.button3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotodisplay();

            }
        });
    }
    void gotodisplay()
    {   String sendname=names.getText().toString().toLowerCase();
        String day=s1.getSelectedItem().toString() ;
        if(!TextUtils.isEmpty(sendname)&&!TextUtils.isEmpty(day)) {
            Intent newintent = new Intent(this, viewingitems.class);
            newintent.putExtra(TNAME, sendname);
            newintent.putExtra(DAY, day);
            startActivity(newintent);

        }
        else{
                Toast.makeText(this, "Insert Name ", Toast.LENGTH_LONG).show();
    }
    }
}
