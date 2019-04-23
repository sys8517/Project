package com.example.project;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class TabFragment1 extends Fragment {

    public TabFragment1() {}

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    EditText editText;
    Button saveBtn;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        final LinearLayout layout1 = (LinearLayout) inflater.inflate(R.layout.tab_fragment1, container,false );


        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference database = firebaseDatabase.getReference();


        return layout1;
    }

}
