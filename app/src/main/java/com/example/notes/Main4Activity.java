package com.example.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Main4Activity extends AppCompatActivity {

     TextView username,firstname,lastname;
     FirebaseDatabase mFirebaseDatabase;
     ChildEventListener mchildEventListener;
     DatabaseReference myRef;
    DatabaseReference vref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        username = findViewById(R.id.textporm);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference().child("transy");
        Query query1 = myRef.child("Userstrim")
                .orderByChild("firstname").limitToFirst(3);
        query1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot singleSnapshot : dataSnapshot.getChildren()){
                    FIreBaseDatabse fire  = singleSnapshot.getValue(FIreBaseDatabse.class);
                    username.setText(fire.getFirstname()+"/n"+fire.getTableid()+"/n"+fire.getTableid());
                    
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
