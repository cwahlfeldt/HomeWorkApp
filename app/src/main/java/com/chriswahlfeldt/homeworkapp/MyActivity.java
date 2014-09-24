package com.chriswahlfeldt.homeworkapp;

        import android.app.Activity;
        import android.content.Context;
        import android.os.Bundle;
        import android.view.View;
        import android.view.inputmethod.InputMethodManager;
        import android.widget.Button;

public class MyActivity extends Activity
{
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;

        final MyHomework myHw = new MyHomework(this);
        setContentView(myHw.getContentView_activity_my());

        final Button addHWBtn = (Button) findViewById(R.id.HWBtn);

            addHWBtn.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            setContentView(myHw.getContentView_add_homework());
                            showSoftKeyboard(myHw.getTitle());
                        }
                    });

        final Button createBtn = (Button) myHw.getContentView_add_homework().findViewById(R.id.createBtn);

            createBtn.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (myHw.post(context).equals(true)) {
                                myHw.post(context);
                                setContentView(myHw.getContentView_activity_my());
                                hideSoftKeyboard(myHw.getTitle());
                            }
                        }
                    });
    }

    public void showSoftKeyboard(View view) {
        if (view.requestFocus()) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
        }
    }

    public void hideSoftKeyboard(View view) {
        if (view.requestFocus()) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }


}