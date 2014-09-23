package com.chriswahlfeldt.homeworkapp;

        import android.app.Activity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

public class MyActivity extends Activity
{

    private MyHomework hW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        hW = new MyHomework();

        setContentView(hW.getContentView_activity_my());
        final Button addHWBtn = (Button) findViewById(R.id.HWBtn);

        addHWBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setContentView(hW.getContentView_add_homework());
                    }
                });
    }
}