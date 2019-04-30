package com.example.project;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ViewDialogFragment extends DialogFragment implements View.OnClickListener {


    public CustomDialog c;

    public static final String TAG_EVENT_DIALOG = "dialog_event";

    public ViewDialogFragment(){}

    public static ViewDialogFragment getInstance() {
        ViewDialogFragment t = new ViewDialogFragment();
        return t;
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog, container, false);
        TextView memoText = v.findViewById(R.id.memoView);
        //memoText.setText(c.memo); //이렇게 가져오는 게 맞는건가?
        return v;
    }

    @Override
    public void onClick(View v) {
        


    }
}
