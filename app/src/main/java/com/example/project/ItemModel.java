package com.example.project;

public class ItemModel {
    String text;

    public ItemModel(String text){
        this.text=text;
    }

    public ItemModel() {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
