package com.example.project;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class    RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private ArrayList<RecyclerModel> recyclerModels;
//    private ItemClick itemClick;

    RecyclerAdapter(ArrayList<RecyclerModel> recyclerModels) {
        this.recyclerModels = recyclerModels;
    }

//    private interface ItemClick {
//        public void onClick(View view, int position);
//
//    }
//
//    public void setItemClick(ItemClick itemClick) {
//        this.itemClick=itemClick;
//    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup,false);
        return new RecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final int Position = i;
        RecyclerModel recyclerModel =recyclerModels.get(i);
        viewHolder.text_Title.setText(recyclerModel.getText());

//        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(itemClick !=null){
//                    itemClick.onClick(v, Position);
//                }
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return recyclerModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text_Title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text_Title=itemView.findViewById(R.id.title);
        }
    }

}
