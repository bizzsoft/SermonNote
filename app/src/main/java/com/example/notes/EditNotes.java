package com.example.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class EditNotes extends AppCompatActivity {
 EditText titles,preacher,sermon;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference vref;
    private String nh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_notes);
         titles =  findViewById(R.id.editTextTextPersonNamed);
         preacher = findViewById(R.id.editTextTextPersonpre);
         sermon = findViewById(R.id.editTextTextMultiLine2);

        final String titleIn = getIntent().getExtras().getString("Title");
        String Preacher= getIntent().getExtras().getString("Preacher");
         final String id = getIntent().getExtras().getString("id");
        Log.i("our id",id);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        vref = mFirebaseDatabase.getReference().child("Note");
        Query query1 = vref.child("Detail");
                query1.orderByChild("id").equalTo(id)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        for(DataSnapshot singleSnapshot : dataSnapshot.getChildren()){
                            String nh = singleSnapshot.getKey();
                            Notes notes  = singleSnapshot.getValue(Notes.class);
                            titles.setText(notes.getTitle().toString());
                            preacher.setText(notes.getPreacher().toString());;
                            sermon.setText(notes.getSermon().toString());
                            Log.i("our erreor",nh);


                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
        titles.setText("");
        preacher.setText("");;
        sermon.setText("");
        FloatingActionButton fab6 = findViewById(R.id.fab6);
        fab6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String ti = titles.getText().toString();
                 final String pre = preacher.getText().toString();
                final  String ser = sermon.getText().toString();
                mFirebaseDatabase = FirebaseDatabase.getInstance();
                vref = mFirebaseDatabase.getReference().child("Note");
                Query query1 = vref.child("Detail");
                query1.orderByChild("id").equalTo(id).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot singleSnapshot : dataSnapshot.getChildren()){
                            String nh = singleSnapshot.getKey();
                            Notes notes  = singleSnapshot.getValue(Notes.class);
                            String id = notes.getId();
                            mFirebaseDatabase = FirebaseDatabase.getInstance();
                            vref = mFirebaseDatabase.getReference().child("Note");
                            vref.child("Detail").child(nh).child("title").setValue(ti);;
                            DatabaseReference vpre,vser;
                            vpre = mFirebaseDatabase.getReference().child("Note");
                            vref.child("Detail").child(nh).child("preacher").setValue(pre);
                            vser = mFirebaseDatabase.getReference().child("Note");
                            vref.child("Detail").child(nh).child("sermon").setValue(ser);

                            Intent intent = new Intent(EditNotes.this, ListShow.class);
                            startActivity(intent);
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });


    }
}