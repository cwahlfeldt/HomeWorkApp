package com.chriswahlfeldt.homeworkapp;

        import android.app.Activity;
        import android.content.Context;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

public class MyActivity extends Activity
{
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final MyHomework myHw = new MyHomework(this);
        setContentView(myHw.getContentView_activity_my());

        final Button addHWBtn = (Button) findViewById(R.id.HWBtn);

            addHWBtn.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            setContentView(myHw.getContentView_add_homework());
                        }
                    });

        final Button createBtn = (Button) myHw.getContentView_add_homework().findViewById(R.id.createBtn);

            context = this;
            createBtn.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            myHw.post(context);
                            setContentView(myHw.getContentView_activity_my());
                        }
                    });
    }
}