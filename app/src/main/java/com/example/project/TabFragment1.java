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
import android.widget.Toast;

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
        final DatabaseReference database = firebaseDatabase.getReference();
        saveBtn=layout1.findViewById(R.id.saveButton);
        editText=layout1.findViewById(R.id.memoEdit);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().trim().length()==0){
                    Toast.makeText(getActivity(),"입력해 주세요",Toast.LENGTH_SHORT).show();
                }
                else{
                    RecyclerModel recyclerModel=new RecyclerModel();
                    recyclerModel.setText(editText.getText().toString());
                    database.push().setValue(recyclerModel);
                }
            }
        });

        return layout1;
    }

}
