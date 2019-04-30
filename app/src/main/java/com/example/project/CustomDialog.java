package com.example.project;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.prolificinteractive.materialcalendarview.CalendarDay;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static android.os.Build.ID;

public class CustomDialog {

    String ID;
    String memo;
    String sort = "date";

    private Context context;
    ArrayAdapter<String> arrayAdapter;

    static ArrayList<String> arrayIndex =  new ArrayList<String>();
    static ArrayList<String> arrayData = new ArrayList<String>();

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
//    final DatabaseReference database = firebaseDatabase.getReference();
    private DatabaseReference mPostReference;


    public CustomDialog(Context context) {
        this.context = context;
    }


    public void postFirebaseDatabase(boolean add){
        mPostReference = FirebaseDatabase.getInstance().getReference();
        Map<String, Object> childUpdates = new HashMap<>();
        Map<String, Object> postValues = null;
        if(add){
            FirebasePost post = new FirebasePost(ID, memo);
            postValues = post.toMap();
        }

        childUpdates.put("/id_list/" + ID, postValues);
        mPostReference.updateChildren(childUpdates);
    }


    public void getFirebaseDatabase() {
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arrayData.clear();
                arrayIndex.clear();
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    String key = postSnapshot.getKey();
                    FirebasePost get = postSnapshot.getValue(FirebasePost.class);
                    String[] info = {get.date, get.memo};
                    String Result = setTextLength(info[0],10) + setTextLength(info[1],10) + setTextLength(info[2],10) + setTextLength(info[3],10);
                    arrayData.add(Result);
                    arrayIndex.add(key);
                }
                arrayAdapter.clear();
                arrayAdapter.addAll(arrayData);
                arrayAdapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        };

        Query sortbyAge = FirebaseDatabase.getInstance().getReference().child("id_list").orderByChild(sort);
        sortbyAge.addListenerForSingleValueEvent(postListener);





    }

    @SuppressLint("ResourceType")
    public void callFunction(final TextView main_label) {

        final Dialog dlg = new Dialog(context);

        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

        dlg.setContentView(R.id.custom);

        dlg.show();

        final EditText message = (EditText) dlg.findViewById(R.id.message);
        final Button okBtn = (Button) dlg.findViewById(R.id.okBtn);
        final Button cancelButton = (Button) dlg.findViewById(R.id.cancelButton);



        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 날짜 얻어오기. ID = get날짜 (메모를 작성하려고 터치한 날짜)
                CalendarDay date = null;
                int Year = date.getYear();
                int Month = date.getMonth();
                int Day = date.getDay();

                ID =  Year + "," + Month + "," + Day;
                memo = message.getText().toString();
                postFirebaseDatabase(true);
                getFirebaseDatabase();




//                // ok 버튼 클릭시 파베에 데이터 보내기
//                database.push().setValue(message.getText().toString());
//                Toast.makeText(context, "\"" +  message.getText().toString() + "\" 을 입력하였습니다.", Toast.LENGTH_SHORT).show();



                // 커스텀 다이얼로그 종료
                dlg.dismiss();
        }
        });


        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 캔슬 시 취소
                Toast.makeText(context, "취소 했습니다.", Toast.LENGTH_SHORT).show();
                // 커스텀 다이얼로그 종료
                dlg.dismiss();

            }
        });
    }
    public String setTextLength(String text, int length){
        if(text.length()<length){
            int gap = length - text.length();
            for (int i=0; i<gap; i++){
                text = text + " ";
            }
        }
        return text;
    }
}
