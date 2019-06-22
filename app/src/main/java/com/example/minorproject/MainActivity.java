package com.example.minorproject;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static java.sql.Types.NULL;

public class MainActivity extends AppCompatActivity {
    private static final String DEBUG_TAG = "MySimpleAppLogging";
    public static final String USERNAME = "com.example.minorproject.userid";
    public static final String PASSWORD = "com.example.minorproject.password";
    DatabaseReference database;
    DatabaseReference childref;
    EditText userid1, pass1;
    Button b1;
    String duserid, dpass, auth, euserid, epass;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);
        userid1 = (EditText) findViewById(R.id.userid);
        pass1 = (EditText) findViewById(R.id.password);
        database=FirebaseDatabase.getInstance().getReference();
        b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick (View v){
        sendmessage();
    }
    });
}
    void sendmessage() {
        euserid = userid1.getText().toString().toLowerCase().trim();
        epass = pass1.getText().toString().toLowerCase().trim();
        if (!TextUtils.isEmpty(euserid) && !TextUtils.isEmpty(epass)) {
            childref = database.child("view").child(euserid);
            childref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    duserid = dataSnapshot.child("userid").getValue().toString().trim();
                    dpass = dataSnapshot.child("password").getValue().toString().trim();
                    auth = dataSnapshot.child("aut").getValue().toString().trim();
                    check();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
            });
        }
        else
        {
            Toast.makeText(this, "enter details", Toast.LENGTH_LONG).show();
        }
    }

    void check()
    {
        if (euserid.equals(duserid)) {
            if (epass.equals(dpass)) {
                if (auth.equals("admin")) {
                    Toast.makeText(this, "Authenticated", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(this, selector.class);
                    i.putExtra(USERNAME, euserid);
                    startActivity(i);
                    }
                else if (auth.equals("faculty")) {
                    Toast.makeText(this, "Authenticated", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(this, facultyview.class);
                    i.putExtra(USERNAME, euserid);
                    startActivity(i);
                    }
                }
            else {
                Toast.makeText(this, "wrong details", Toast.LENGTH_LONG).show();
                }
            }
        else {
            Toast.makeText(this, "wrong details", Toast.LENGTH_LONG).show();
            }

    }
}
