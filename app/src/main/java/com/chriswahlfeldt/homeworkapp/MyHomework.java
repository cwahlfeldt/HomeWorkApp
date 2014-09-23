package com.chriswahlfeldt.homeworkapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class MyHomework extends Activity {

    private EditText title, description;
    private View homeworkView, activityView;

    // default constructor
    public MyHomework(Context myContext) {

        // sets inflater to the context of MyActivity.java
        LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        homeworkView = inflater.inflate(R.layout.add_homework, null);
        activityView = inflater.inflate(R.layout.activity_my, null);

        title = (EditText) homeworkView.findViewById(R.id.classTitleET);
        title.setText("");

        description = (EditText) homeworkView.findViewById(R.id.descriptionET);
        title.setText("");

    }

    public View getContentView_activity_my() { return activityView; }

    public View getContentView_add_homework() { return homeworkView; }

    public String getTitleTxt() { return title.getText().toString(); }

    public String getDescriptionTxt() { return description.getText().toString(); }

    public void setTitleTxt(String thatString) { title.setText(thatString); }

    public void setDescriptionTxt(String thatString) { title.setText(thatString); }
}
