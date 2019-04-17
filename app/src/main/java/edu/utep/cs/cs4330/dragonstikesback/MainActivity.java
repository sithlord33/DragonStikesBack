package edu.utep.cs.cs4330.dragonstikesback;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;
    private GestureDetectorCompat gestureDetectorCompat;
    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.detect_swipe_direction_textview);
        imageView = findViewById(R.id.imageView);
        imageView.setAlpha(127);

        game = new Game(50);

        DetectSwipeGestureListener gestureListener = new DetectSwipeGestureListener();

        gestureListener.setActivity(this);

        gestureDetectorCompat = new GestureDetectorCompat(this, gestureListener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        imageView.setImageResource(android.R.color.transparent);
        if (game.isWin()) {
            finish();
        }
        try {
            displayImage(game.nextInstruction());
        }
        catch (  java.util.NoSuchElementException e){
        }
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void displayMessage(String message) {
        if (textView != null)
            textView.setText(message);
    }

    public void displayImage(int value) {
        switch (value) {
            case 0:
                imageView.setImageResource(R.drawable.up);
                break;
            case 1:
                imageView.setImageResource(R.drawable.down);
                break;
            case 2:
                imageView.setImageResource(R.drawable.left);
                break;
            case 3:
                imageView.setImageResource(R.drawable.right);
                break;
            case 4:
                imageView.setImageResource(R.drawable.defend);
                break;
            case 5:
                imageView.setImageResource(R.drawable.attack);
                break;
            default:
                imageView.setImageResource(R.drawable.start);
        }
    }
}