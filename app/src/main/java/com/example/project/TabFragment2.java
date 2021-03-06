package com.example.project;

import android.app.Dialog;
import android.icu.util.Freezable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class TabFragment2 extends Fragment {

    public TabFragment2(){}
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        final LinearLayout layout2 = (LinearLayout) inflater.inflate(R.layout.tab_fragment2, container, false);
        final ArrayList<RecyclerModel> recyclerModel = new ArrayList<>();
        RecyclerView recyclerView= layout2.findViewById(R.id.recyclerView);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference database = firebaseDatabase.getReference();
        final RecyclerAdapter rAdapter = new RecyclerAdapter(recyclerModel);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(rAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);

//
//        rAdapter.setItemClick(new RecyclerAdapter.ItemClick() {
//            @Override
//            public void onClick(View view, int position) {
//                Dialog();
//
//
//            }
//        });

        database.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                RecyclerModel recyclerModel1=dataSnapshot.getValue(RecyclerModel.class);
                recyclerModel.add(recyclerModel1);
                rAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return layout2;
    }
}
