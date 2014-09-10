package com.chriswahlfeldt.homeworkapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MyActivity extends Activity {

    final Context context = this;
    private Button addClassBtn;
    private TextView classNameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        addClassBtn = (Button) findViewById(R.id.classBtn);
        classNameInput = (TextView) findViewById(R.id.classNameInput);

        final LayoutInflater classInfo = getLayoutInflater();

//    **adds a new layout**
//      final LayoutInflater classTab = getLayoutInflater();

        // creates a alert box with a text view when button is clicked
        addClassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setView(classInfo.inflate(R.layout.class_info, null));

                builder.setTitle("Add Class");

                AlertDialog diaBox = builder.create();

                diaBox.show();

                addClassBtn.setVisibility(view.GONE);
                addClassBtn.setVisibility(view.VISIBLE);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}