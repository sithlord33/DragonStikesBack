package edu.utep.cs.cs4330.dragonstikesback;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private GestureDetectorCompat gestureDetectorCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.detect_swipe_direction_textview);

        DetectSwipeGestureListener gestureListener = new DetectSwipeGestureListener();

        gestureListener.setActivity(this);

        gestureDetectorCompat = new GestureDetectorCompat(this, gestureListener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return true;
    }

    public void displayMessage(String message) {
        if (textView != null)
            textView.setText(message);
    }
}