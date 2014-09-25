package com.chriswahlfeldt.homeworkapp;

        import android.content.Context;
        import android.graphics.Color;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.EditText;
        import android.widget.RelativeLayout;
        import android.widget.TextView;
        import java.util.ArrayList;
        import java.util.List;

public class MyHomework extends MyReminder{

    private EditText title, description;
    private View homeworkView, activityView;
    private RelativeLayout mainRelLayout;
    private int counter;
    private Context context;
    private MyReminder myReminder;

    // default "constructor"
    public MyHomework(){
        // DO NOT USE
    }

    public MyHomework(Context myContext){

        // sets inflater to the context of MyActivity.java
        LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        homeworkView = inflater.inflate(R.layout.add_homework, null);
        activityView = inflater.inflate(R.layout.activity_my, null);
        mainRelLayout = (RelativeLayout) activityView.findViewById(R.id.mainLayout);

        title = (EditText) homeworkView.findViewById(R.id.classTitleET);
        title.setText("");

        description = (EditText) homeworkView.findViewById(R.id.descriptionET);
        title.setText("");

        context = myContext;
    }

    public View getContentView_activity_my() { return activityView; }

    public View getContentView_add_homework() { return homeworkView; }

    public TextView getTitle() { return title; }

    public Context getContext() { return context; }

    public String getDescriptionTxt() { return description.getText().toString(); }

    public void setTitleTxt(String thatString) { title.setText(thatString); }

    public void setDescriptionTxt(String thatString) { title.setText(thatString); }

    // posts a new relative layout containing a text view to the main layout on the activity_my.xml
    // returns a boolean value
    public void post(Context myContext){

        // declares and sets vars specific to the post function
        TextView txt = new TextView(myContext);
        RelativeLayout postRelLayout = new RelativeLayout(myContext);
        List<RelativeLayout> postRelLayoutList = new ArrayList<RelativeLayout>();
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        // sets unique id to each post
        postRelLayout.setId(counter++);

        // adds parameters to each post
        params.addRule(RelativeLayout.BELOW, counter);
        params.setMargins(15,20,15,20);

        // if you don't put title in than you get a nice little toast telling you to put it in
//        if (!title.getText().toString().equals("")){

            String titleStr = title.getText().toString();
            String descriptionStr = description.getText().toString();

            txt.setTextSize(20);
            txt.setPadding(40, 30, 30, 30);
            txt.setTextColor(Color.LTGRAY);

            txt.setText(titleStr + " | " + descriptionStr);

            postRelLayout.addView(txt);
            postRelLayoutList.add(postRelLayout);

            postRelLayout.setLayoutParams(params);
            postRelLayout.setBackgroundColor(Color.argb(230, 27, 27, 30));

            // adds a new post to a list array
            for (RelativeLayout aPostRelLayoutList : postRelLayoutList) {

                mainRelLayout.addView(aPostRelLayoutList);
            }

            title.setText("");
            description.setText("");

//            return true;
//        }
//        else{
            // creates and shows a toast in middle of screen
//            Toast toast = Toast.makeText(myContext, "Please add a name for your class", Toast.LENGTH_SHORT);
//            toast.setGravity(Gravity.CENTER,0,-25);
//            toast.show();
//
//          return false;
//        }
    }
}
