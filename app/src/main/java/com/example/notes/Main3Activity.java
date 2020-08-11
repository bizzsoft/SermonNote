package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main3Activity extends AppCompatActivity  {

    private String Tilev;
    public EditText first;
    public EditText username;
    public EditText Lastname;
    public String firstname;
    public String Username;
    public String lastname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("transy");

        Button button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText first = findViewById(R.id.fname);
                EditText username = findViewById(R.id.uname);
                EditText Lastname = findViewById(R.id.Lname);
                final String firstname = first.getText().toString();
                final String Username = username.getText().toString();
                final String lastname = Lastname.getText().toString();
                 first.setText(firstname);
                 username.setText(Username);
                 Lastname.setText(lastname);
                DatabaseReference vref = myRef.child("Userstrim");
                String id = vref.push().getKey();
                FIreBaseDatabse firebase = new FIreBaseDatabse(id,Username,firstname,lastname);
                vref.push().setValue(firebase);
              Toast.makeText(getApplicationContext(),"this is your firstname"+firstname,Toast.LENGTH_LONG).show();
              Intent intent = new Intent(Main3Activity.this,Main4Activity.class);
              startActivity(intent);

            }
        });


    }
   public String savaData(String TitleV){

        return TitleV;

   }
}
