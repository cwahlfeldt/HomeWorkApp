package com.chriswahlfeldt.homeworkapp;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;

public class MyHomework extends Activity {

    private EditText title, description;
    private View homeworkView, activityView;

    // default constructor
    public MyHomework() {

        homeworkView = getLayoutInflater().inflate(R.layout.add_homework, null);
        activityView = getLayoutInflater().inflate(R.layout.activity_my, null);

        title.setText("");
        title = (EditText) homeworkView.findViewById(R.id.classTitleET);

        description.setText("");
        description = (EditText) homeworkView.findViewById(R.id.descriptionET);
    }

    public View getContentView_activity_my() { return activityView; }

    public View getContentView_add_homework() { return homeworkView; }

    public String getTitleTxt() { return title.getText().toString(); }

    public String getDescriptionTxt() { return description.getText().toString(); }

    public void setTitleTxt(String thatString) { title.setText(thatString); }

    public void setDescriptionTxt(String thatString) { title.setText(thatString); }
}
