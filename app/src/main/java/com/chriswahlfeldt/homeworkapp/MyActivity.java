package com.chriswahlfeldt.homeworkapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;

public class MyActivity extends Activity {


    // declares vars
    final Context CONTEXT = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        // initializes var
        final LayoutInflater classInfo = getLayoutInflater();
        final View inflater = classInfo.inflate(R.layout.class_info, null);
        final LinearLayout classTabLayout = new LinearLayout(this);
        final Button addClassBtn = (Button) findViewById(R.id.classBtn);
        final TextView tv = new TextView(this);
        final EditText classNameInput = new EditText(this);


        // creates a alert box with a text view when button is clicked
        addClassBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(CONTEXT);

                        builder.setView(classInfo.inflate(R.layout.class_info, null));
                        builder.setTitle("Add Class");

                        // makes a button that when pressed,
                        // puts the text that you entered
                        // into a string and creates a new textview
                        // and puts it into a new layout
                        builder.setPositiveButton("create", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton)
                            {

                                // no input is put here?
                                String str = classNameInput.getText().toString();

                                tv.setText(str);
                                tv.setTextSize(25);
                                tv.setGravity(Gravity.CENTER);

                                classTabLayout.setOrientation(LinearLayout.VERTICAL);
//   causing problems  **         classTabLayout.setLayoutParams
//   causing problems  **             (new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                                classTabLayout.addView(tv);

                            }
                        });
                        setContentView(classTabLayout);
                        builder.show();
                    }

        });

    }
}