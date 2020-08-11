package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addNotes extends AppCompatActivity {
 EditText Title;
 EditText Preacher;
 EditText sermon;
 DatabaseReference mref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);
        Title = findViewById(R.id.editTextTextTitle);
        Preacher = findViewById(R.id.editTextTextPreacher);
        sermon = findViewById(R.id.editTextTextMultiLine4);

           FloatingActionButton fab1 = findViewById(R.id.fab6);
           fab1.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   String TitleS = Title.getText().toString();
                   String Preach = Preacher.getText().toString();
                   String ser = sermon.getText().toString();
                   if(TitleS.equals("") && Preach.equals("") && ser.equals("")) {
                       Toast.makeText(getApplicationContext(),"your  title or preacher or sermon field is empty", Toast.LENGTH_LONG).show();
                   }else{
                       FirebaseDatabase database = FirebaseDatabase.getInstance();
                       final DatabaseReference myRef = database.getReference("Note");
                       DatabaseReference vref = myRef.child("Detail");
                       String id = vref.push().getKey();
                       Notes notes = new Notes(TitleS, Preach, ser, id);
                       vref.push().setValue(notes);
                       Toast.makeText(getApplicationContext(), "the title of the save notes is" + TitleS, Toast.LENGTH_LONG).show();
                       Intent intent = new Intent(addNotes.this, ListShow.class);
                       startActivity(intent);

                   }
               }
           });

    }
}