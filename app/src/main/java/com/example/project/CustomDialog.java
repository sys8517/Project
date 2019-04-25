package com.example.project;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CustomDialog {
    private Context context;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    final DatabaseReference database = firebaseDatabase.getReference();


    public CustomDialog(Context context) {
        this.context = context;
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
                // ok 버튼 클릭시 파베에 데이터 보내기
                database.push().setValue(message.getText().toString());
                Toast.makeText(context, "\"" +  message.getText().toString() + "\" 을 입력하였습니다.", Toast.LENGTH_SHORT).show();

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
}
