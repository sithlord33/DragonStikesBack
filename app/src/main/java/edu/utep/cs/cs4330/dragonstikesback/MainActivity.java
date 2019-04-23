package edu.utep.cs.cs4330.dragonstikesback;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        Constants.SCREEN_WIDTH = dm.widthPixels;
        Constants.SCREEN_HEIGHT = dm.heightPixels;

        setContentView(new GamePanel(this));

        /*textView = findViewById(R.id.detect_swipe_direction_textview);
        imageView = findViewById(R.id.imageView);
        imageView.setAlpha(127);

        game = new Game(50);

        DetectSwipeGestureListener gestureListener = new DetectSwipeGestureListener();

        gestureListener.setActivity(this);

        gestureDetectorCompat = new GestureDetectorCompat(this, gestureListener);*/
    }

    /*@Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        String params = "50";
        asyncTask = new InstructionTask().execute(params);
        return true;
    }

    public void displayMessage(String DIRECTION) {
        if (textView != null)
            textView.setText(DIRECTION);
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
    }*/
}