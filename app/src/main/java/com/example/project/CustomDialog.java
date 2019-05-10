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

import com.google.android.gms.tasks.OnSuccessListener;
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

    static ArrayList<String> arrayIndex = new ArrayList<String>();
    static ArrayList<String> arrayData = new ArrayList<String>();

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mPostReference;


    public CustomDialog(Context context) {
        this.context = context;
    }


    @SuppressLint("ResourceType")
    public void callFunction(final TextView main_label, final String day) {

        final TabFragment3 t3 = new TabFragment3();

        final Dialog dlg = new Dialog(context);

        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

        dlg.setContentView(R.layout.custom);

        dlg.show();

        final EditText message = (EditText) dlg.findViewById(R.id.message);
        final Button okBtn = (Button) dlg.findViewById(R.id.okBtn);
        final Button cancelButton = (Button) dlg.findViewById(R.id.cancelButton);


        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 날짜 얻어오기. ID = get날짜 (메모를 작성하려고 터치한 날짜)

                //여기서 오류남 (널포인트 익셉션) ?
                // 그냥 함수만 써야하나 함수는 post에 따로 구현?


                DatabaseReference database = firebaseDatabase.getReference();
                RecyclerModel recyclerModel = new RecyclerModel();
                recyclerModel.setText(message.getText().toString());
//                // ok 버튼 클릭시 파베에 데이터 보내기
                database.child(day).push().setValue(recyclerModel).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(context, "\"" + message.getText().toString() + "\" 을 입력하였습니다.", Toast.LENGTH_SHORT).show();
                    }
                });

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

    public String setTextLength(String text, int length) {
        if (text.length() < length) {
            int gap = length - text.length();
            for (int i = 0; i < gap; i++) {
                text = text + " ";
            }
        }
        return text;
    }
}
