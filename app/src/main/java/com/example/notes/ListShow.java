package com.example.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListShow extends AppCompatActivity {
    FirebaseDatabase mFirebaseDatabase;
   // ChildEventListener mchildEventListener;
    DatabaseReference myRef;
    DatabaseReference vref;
    RecyclerView recyclerView;
     ArrayList<Notes> list;
    myAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_show);

        list = new ArrayList<Notes>();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        vref = mFirebaseDatabase.getReference().child("Note");
        vref.child("Detail").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                   Notes  notes = dataSnapshot1.getValue(Notes.class);
                   list.add(notes);
               }
                recyclerView =  findViewById(R.id.recyclerview);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager( new LinearLayoutManager(ListShow.this));
                recyclerView.getLayoutManager().setMeasurementCacheEnabled(false);
               adapter = new myAdapter(ListShow.this,list);
               recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        FloatingActionButton fab = findViewById(R.id.fabadd);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListShow.this, addNotes.class);
                startActivity(intent);
            }
        });
    }

}