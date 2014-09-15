package com.chriswahlfeldt.homeworkapp;

import android.app.Activity;

public class MyHomework extends Activity {

    private String MyString1 = "", MyString2 = "";

    public String getString1() {
        return MyString1;
    }

    public String getString2() {
        return MyString2;
    }

    public void setString1(String thatString1) {
        MyString1 = thatString1;
    }

    public void setString2(String thatString2) {
        MyString2 = thatString2;
    }

}
