package com.example.project;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.google.android.gms.common.internal.safeparcel.SafeParcelable.NULL;

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


        //memo 가져오는 거 어떻게 하지
        return v;
    }

    @Override
    public void onClick(View v) {
        


    }
}
