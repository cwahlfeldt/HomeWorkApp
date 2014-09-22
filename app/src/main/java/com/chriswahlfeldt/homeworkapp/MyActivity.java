package com.chriswahlfeldt.homeworkapp;


import android.app.Activity;
import java.util.*;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MyActivity extends Activity
{

    // declares vars
    final Context CONTEXT = this;
    int num1 = 25;
    int counter = 0;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            final LayoutInflater homeworkAdd = getLayoutInflater();
            final View addHomeworkView = homeworkAdd.inflate(R.layout.add_homework, null);
            final View activityMy = homeworkAdd.inflate(R.layout.activity_my, null);

            setContentView(activityMy);

            final List<View> txtView = new ArrayList<View>();

            do {
                addHomework(addHomeworkView, activityMy, txtView);
                num1--;
            } while (num1 != 0);

        }

    private void addHomework(final View addHomeworkView, final View activityMy, final List<View> txtView)
    {

        final EditText title = (EditText) addHomeworkView.findViewById(R.id.classTitleET);
        final EditText description = (EditText) addHomeworkView.findViewById(R.id.descriptionET);

        final RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        final RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        final Button addHWBtn = (Button) activityMy.findViewById(R.id.HWBtn);

        addHWBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setContentView(addHomeworkView);
            }
        });

        final Button createBtn = (Button) addHomeworkView.findViewById(R.id.createBtn);

        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!title.getText().toString().equals(""))
                {

                    RelativeLayout relativeLayout = new RelativeLayout(getApplicationContext());
                    RelativeLayout firstRelativeLayout = new RelativeLayout(getApplicationContext());

                    TextView firstTxt = new TextView(CONTEXT);
                    TextView txt = new TextView(CONTEXT);

                    firstRelativeLayout.setId(0);
                    relativeLayout.setId(counter);

                    String temp = "";

                    params.addRule(RelativeLayout.BELOW, addHWBtn.getId());
                    params1.addRule(RelativeLayout.BELOW, relativeLayout.getId());

                    if (counter == 0) temp = title.getText().toString() + "\n" + "\n" + description.getText().toString();

                    firstTxt.setText(temp);
                    firstTxt.setId(0);

                    if (counter > 0) txt.setText(title.getText().toString() + "\n" + "\n" + description.getText().toString());
                    txt.setId(counter);

                    txtView.add(0, firstTxt);
                    txtView.add(txt);

                    firstRelativeLayout.setLayoutParams(params);
                    firstRelativeLayout.addView(txtView.get(0));

                    if (txt.getId() > 0)
                    {
                        relativeLayout.setLayoutParams(params1);
                        relativeLayout.addView(txtView.get(counter));
                    }
                    if (counter == 0) counter++;

                    RelativeLayout rootLayout = (RelativeLayout) activityMy.findViewById(R.id.mainRelLayout);
                    rootLayout.addView(firstRelativeLayout);
                    rootLayout.addView(relativeLayout);

                    setContentView(activityMy);

                    title.setText("");
                    description.setText("");

                }
                else
                {
                    Toast toast = Toast.makeText(CONTEXT, "Please add a name for your class", Toast.LENGTH_SHORT);
                    toast.show();

                }
            }
        });
    }

    private void addToHomework()
    {

    }

    //older dialog box way of doing things

    // creates an alert box with an EditText when button is clicked
    // the EditText can add a title to a new layout
//    private void addClass(){
//
//        final LayoutInflater classInfo = getLayoutInflater();
//        final LayoutInflater classTab = getLayoutInflater();
//        addClassBtn = (Button) findViewById(R.id.classBtn);
//
//        addClassBtn.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//
//                        final AlertDialog.Builder builder = new AlertDialog.Builder(CONTEXT);
//
//                        final View dialogView = classInfo.inflate(R.layout.class_info, null);
//                        final View newClassLayout = classTab.inflate(R.layout.class_tab, null);
//
//                        //sets a custom view to builder
//                        builder.setView(dialogView);
//
//                        builder.setTitle("Add Class");
//
//                        AlertDialog diaBox = builder.create();
//
//                        //initializes custom view
//                        setDialogViews(dialogView, newClassLayout, diaBox);
//
//                        diaBox.show();
//                    }
//                });
//    }
//
//    // initializes variables for custom view layout and adds a title to a new layout
//    private void setDialogViews(final View dialogView, View newClassLayout, final AlertDialog diaBox){
//        classNameInput = (EditText) dialogView.findViewById(R.id.classNameInput);
//        createBtn = (Button) dialogView.findViewById(R.id.createBtn);
//        classLayout = (LinearLayout) newClassLayout.findViewById(R.id.classTab);
//        titleView = (TextView) newClassLayout.findViewById(R.id.titleText);
//
//        //classNameInput is extracted to a variable
//        createBtn.setOnClickListener(
//                new View.OnClickListener() {
//
//                    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
//                    @Override
//                    public void onClick(View view) {
//                        String className = classNameInput.getText().toString();
//
//                        if (!className.equals(""))
//                        {
//                            titleView.setText(className);
//                            titleView.setTextSize(40);
//
//                            // needed for creating a new view
//                            classLayout.removeAllViews();
//                            classLayout.addView(titleView);
//
//                            setContentView(classLayout);
//
//                            diaBox.dismiss();
//                        }
//                        else
//                        {
//                            Toast toast = Toast.makeText(CONTEXT, "Please add a name for your class", Toast.LENGTH_SHORT);
//                            toast.show();
//                        }
//                    }
//                });
//    }

    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
}