package com.example.minorproject;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Logger;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class facultyfreeslots extends AppCompatActivity {
    private static final String TAG = "MyActivity";
    TextView t1;
    Button b1;
    Spinner day, time;
    EditText name,name2;
    String dvalue1, dvalue2,timestring1;
    String a,b;
    String daystring, timestring,name11, name12;
    DatabaseReference d1,d2,fname,fname1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facultyfreeslots);
        t1=findViewById(R.id.textView50);
        name=findViewById(R.id.editText4);
        name2=findViewById(R.id.editText5);
        b1=findViewById(R.id.button9);
        day=findViewById(R.id.spinner18);
        time=findViewById(R.id.spinner19);
        FirebaseApp.initializeApp(this);
        d1= FirebaseDatabase.getInstance().getReference("teacher");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                matchslots();
            }
        });
    }

    void matchslots() {  // getdata();
        name11 = name.getText().toString().toLowerCase();
        name12 = name.getText().toString().toLowerCase();
        daystring = day.getSelectedItem().toString().trim();
        timestring = time.getSelectedItem().toString().trim();
        if (timestring.equals("8:30-9:30")) {
            timestring1 = "a";
        } else if (timestring.equals("9:30-10:30")) {
            timestring1 = "b";

        } else if (timestring.equals("10:30-11:30")) {
            timestring1 = "c";

        } else if (timestring.equals("11:30-12:30")) {
            timestring1 = "d";

        } else if (timestring.equals("12:30-1:30")) {
            timestring1 = "e";

        } else if (timestring.equals("1:30-2:30")) {
            timestring1 = "f";

        } else if (timestring.equals("2:30-3:30")) {
            timestring1 = "g";

        } else if (timestring.equals("3:30-4:30")) {
            timestring1 = "h";

        } else if (timestring.equals("4:30-5:30")) {
            timestring1 = "i";

        } else {
            timestring1 = "j";
        }
        if (!TextUtils.isEmpty(name11) && !TextUtils.isEmpty(name12)) {
            d1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    dvalue1 = dataSnapshot.child(name11).child(daystring).child(timestring1).getValue().toString().trim();
                    dvalue2 = dataSnapshot.child(name12).child(daystring).child(timestring1).getValue().toString().trim();
               /* if(dvalue1.equals("no class"))
                {
                    a= "0";
                }

                else {
                    a="1";
                }
                if(dvalue2.equals("no class"))
                {
                    b="0";
                }
                else
                {
                    b="1";
                }
                */
                    if (dvalue1.equals("no class") && dvalue2.equals("no class")) {
                        t1.setText("free");
                    } else {
                        t1.setText("not free");
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Log.d(TAG, "Failed to read value.");
                }
            });
        }
         else
        {
            Toast.makeText(this, "Insert Names", Toast.LENGTH_SHORT).show();
            }

    }
}
