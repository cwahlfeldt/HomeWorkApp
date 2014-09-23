package com.chriswahlfeldt.homeworkapp;

        import android.app.Activity;
        import android.content.Context;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

public class MyActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        final EditText title, description;
        final View homeworkView, activityView;
        final Button addHWBtn = (Button) findViewById(R.id.HWBtn);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        homeworkView = inflater.inflate(R.layout.add_homework, null);
        activityView = inflater.inflate(R.layout.activity_my, null);

        title = (EditText) homeworkView.findViewById(R.id.classTitleET);
        title.setText("");

        description = (EditText) homeworkView.findViewById(R.id.descriptionET);
        description.setText("");


        addHWBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setContentView(R.layout.add_homework);
                    }
                });
    }
}