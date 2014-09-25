package com.chriswahlfeldt.homeworkapp;

        import android.annotation.TargetApi;
        import android.app.Activity;
        import android.app.Notification;
        import android.app.NotificationManager;
        import android.content.Context;
        import android.os.Build;
        import android.os.Bundle;
        import android.view.View;
        import android.view.inputmethod.InputMethodManager;
        import android.widget.Button;
        import android.os.SystemClock;
        import android.app.AlarmManager;
        import android.app.PendingIntent;
        import android.content.BroadcastReceiver;
        import android.content.Intent;
        import android.content.IntentFilter;
        import android.widget.ImageButton;

public class MyActivity extends Activity
{
    private Context context;
    final static private long ONE_SECOND = 1000;
    final static private long five_seconds = ONE_SECOND * 5;
    PendingIntent pi;
    BroadcastReceiver br;
    AlarmManager am;

    int counterID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;

        final MyHomework myHw = new MyHomework(this);

        setContentView(myHw.getContentView_activity_my());

        final Button addHWBtn = (Button) findViewById(R.id.HWBtn);

        setup();

            // adding homework btn clicked
            addHWBtn.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            setContentView(myHw.getContentView_add_homework());
                            showSoftKeyboard(myHw.getTitle());
                        }
                    });

        final ImageButton timerBtn = (ImageButton)  myHw.getContentView_add_homework().findViewById(R.id.imgBtn);

        final Button createBtn = (Button) myHw.getContentView_add_homework().findViewById(R.id.createBtn);

            // when timer is clicked
            timerBtn.setOnClickListener(
                    new View.OnClickListener() {
                        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                        @Override
                        public void onClick(View view) {
                            counterID++;
                            am.set( AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() +
                                    five_seconds, pi );
                        }
                    });

            // when create button is clicked
            createBtn.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                myHw.post(context);
                                setContentView(myHw.getContentView_activity_my());
                                hideSoftKeyboard(myHw.getTitle());
                        }
                    });
    }

    // needed top clean up alarm clock
//    protected void onDestroy() {
//        am.cancel(pi);
//        unregisterReceiver(br);
//        super.onDestroy();
//    }

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

    // The private method setup initializes the class level variables,
    // including the new broadcast receiver that will act as the callback for our alarm.
    private void setup() {
        br = new BroadcastReceiver() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onReceive(Context c, Intent i) {
//                Toast.makeText(c, getString(R.string.riseandshit), Toast.LENGTH_SHORT).show();

                final NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                final Notification.Builder noti = new Notification.Builder(c);
                noti.setContentTitle("my title")
                        .setContentText("some text");

                mNotifyMgr.notify(counterID, noti.build());
            }
        };
        registerReceiver(br, new IntentFilter("com.chriswahlfeldt.homeworkapp") );
        pi = PendingIntent.getBroadcast( this, 0, new Intent("com.chriswahlfeldt.homeworkapp"), 0 );
        am = (AlarmManager)(this.getSystemService( Context.ALARM_SERVICE ));
    }

}