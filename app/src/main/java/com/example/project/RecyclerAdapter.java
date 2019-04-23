package com.example.project;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private ArrayList<RecyclerModel> recyclerModels;
    RecyclerAdapter(ArrayList<RecyclerModel> recyclerModels) {
        this.recyclerModels = recyclerModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup,false);
        return new RecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        RecyclerModel recyclerModel =recyclerModels.get(i);
        viewHolder.text_Title.setText(recyclerModel.getText());

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
