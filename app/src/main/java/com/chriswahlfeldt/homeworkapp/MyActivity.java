package com.chriswahlfeldt.homeworkapp;


import android.app.Activity;
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

public class MyActivity extends Activity
{

    // declares vars
    final Context CONTEXT = this;
//    private LinearLayout classLayout;
//    private TextView titleView;
//    public EditText classNameInput;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_my);

//            addClass();
            addHomework();



        }

    private void addHomework()
    {
        final LayoutInflater homeworkAdd = getLayoutInflater();
        final View addHomeworkView = homeworkAdd.inflate(R.layout.add_homework, null);

        final EditText title = (EditText) addHomeworkView.findViewById(R.id.classTitleET);
        final EditText description = (EditText) addHomeworkView.findViewById(R.id.descriptionET);

        Button addHWBtn = (Button) findViewById(R.id.HWBtn);

        addHWBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setContentView(addHomeworkView);

                if (!title.getText().toString().equals(""))
                {

                }
                else
                {
                    Toast toast = Toast.makeText(CONTEXT, "Please add a name for your class", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });
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