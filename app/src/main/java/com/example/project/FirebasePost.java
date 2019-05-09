package com.example.project;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import static android.os.Build.ID;

public class FirebasePost {
    public String date;
    public String memo;
//    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
//    final DatabaseReference mPostReference = firebaseDatabase.getReference();


    public FirebasePost(){
        // Default constructor required for calls to DataSnapshot.getValue(FirebasePost.class)
    }
    public FirebasePost(String date, String memo) {
        this.date = date;
        this.memo = memo;
    }



}
