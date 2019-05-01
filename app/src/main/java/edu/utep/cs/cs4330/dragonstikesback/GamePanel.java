package edu.utep.cs.cs4330.dragonstikesback;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.support.v4.view.GestureDetectorCompat;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.concurrent.TimeUnit;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;

    private Rect r = new Rect();
    private Rect a = new Rect(100,100,100,100);

    private Player player;
    private Point playerPoint;
    private Action actions;

    private GestureDetectorCompat gestureDetectorCompat;
    private MediaPlayer mp;

    private long frameTime;

    public static int DIRECTION;

    private boolean gameOver = false;

    public GamePanel(Context context) {
        super(context);

        getHolder().addCallback(this);

        Constants.CURRENT_CONTEXT = context;

        thread = new MainThread(getHolder(), this);

        player = new Player(new Rect(100, 100, 200, 200));
        playerPoint = new Point(Constants.SCREEN_WIDTH / 4, Constants.SCREEN_HEIGHT / 4);
        player.update(playerPoint);

        actions = new Action();

        DetectSwipeGestureListener gestureListener = new DetectSwipeGestureListener();
        gestureListener.setActivity((MainActivity) Constants.CURRENT_CONTEXT);
        gestureDetectorCompat = new GestureDetectorCompat(context, gestureListener);

        mp = new MediaPlayer();

        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new MainThread(getHolder(), this);
        Constants.INIT_TIME = System.currentTimeMillis();

        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
                thread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        player.setDirection(DIRECTION);
        actions.update();

        return true;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        canvas.drawColor(Color.rgb(85,10,20));

        Paint paint = new Paint();
        paint.setTextSize(100);
        paint.setColor(Color.MAGENTA);

        try {
            TimeUnit.MILLISECONDS.sleep(500);
            actions.draw(canvas, a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        player.draw(canvas);

        canvas.getClipBounds(a);
        drawCenterText(canvas, paint, String.valueOf(DIRECTION));

        if (gameOver) {
            paint = new Paint();
            paint.setTextSize(100);
            paint.setColor(Color.MAGENTA);
            drawCenterText(canvas, paint, "Game Over");
        }
    }

    public void update() {
        if (!gameOver) {
            if (frameTime < Constants.INIT_TIME)
                frameTime = Constants.INIT_TIME;
            int elapsedTime = (int) (System.currentTimeMillis() - frameTime);
            frameTime = System.currentTimeMillis();

            player.update(playerPoint);

            /*
            player.update(playerPoint);
            obstacleManager.update();

            if (obstacleManager.playerCollide(player))
                gameOver = true;*/
        }
    }

    private void drawCenterText(Canvas canvas, Paint paint, String text) {
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.getClipBounds(r);
        int cHeight = r.height();
        int cWidth = r.width();
        paint.getTextBounds(text, 0, text.length(), r);
        float x = cWidth / 2f - r.width() / 2f - r.left;
        float y = cHeight / 2f + r.height() / 2f - r.bottom;
        canvas.drawText(text, x, y, paint);
    }
}
