package com.chriswahlfeldt.homeworkapp;

import android.app.Activity;

public class MyHomework extends Activity {

    private String title = null, description = null;

    public String getTitleTxt() {
        return title;
    }

    public String getDescriptionTxt() {
        return description;
    }

    public void setTitleTxt(String thatString1) {
        title = thatString1;
    }

    public void setDescriptionTxt(String thatString2) {
        description = thatString2;
    }

    }
