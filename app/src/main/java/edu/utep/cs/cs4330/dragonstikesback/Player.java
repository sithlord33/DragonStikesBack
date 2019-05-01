package edu.utep.cs.cs4330.dragonstikesback;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

public class Player {
    private int lives;
    private int direction;

    private Rect rectangle;

    private Animation idle;
    private Animation walk;
    private Animation hurt;
    private Animation jump;
    private Animation duck;
    private Animation swim;
    private Animation climb;
    private AnimationManager animManager;

    public Rect getRectangle() {
        return rectangle;
    }

    Player(Rect rectangle) {
        this.rectangle = rectangle;

        BitmapFactory bf = new BitmapFactory();
        Bitmap idleImg = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.alienbeige);
        Bitmap walk1 = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.alienbeige_walk1);
        Bitmap walk2 = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.alienbeige_walk2);
        Bitmap hurt1 = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.alienbeige_hurt);
        Bitmap jump1 = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.alienbeige_jump);
        Bitmap duck1 = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.alienbeige_duck);
        Bitmap swim1 = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.alienbeige_swim1);
        Bitmap swim2 = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.alienbeige_swim2);
        Bitmap climb1 = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.alienbeige_climb1);
        Bitmap climb2 = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.alienbeige_climb2);


        idle = new Animation(new Bitmap[]{idleImg}, 1);
        walk = new Animation((new Bitmap[]{walk1, walk2}), 0.5f);
        hurt = new Animation(new Bitmap[]{hurt1}, 1);
        jump = new Animation(new Bitmap[]{jump1}, 1);
        duck = new Animation(new Bitmap[]{duck1}, 1);
        swim = new Animation(new Bitmap[]{swim1, swim2}, 0.5f);
        climb = new Animation(new Bitmap[]{climb1, climb2}, 0.5f);

        animManager = new AnimationManager(new Animation[]{idle, walk, hurt, jump, duck, swim, climb});

        lives = 5;
    }

    public boolean isDead() {
        if (this.lives <= 0) {
            return true;
        }
        return false;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

    public void decreaseLives() {
        lives--;
    }

    public void draw(Canvas canvas) {
        animManager.draw(canvas, rectangle);

        Paint paint = new Paint();
        paint.setTextSize(100);
        paint.setColor(Color.MAGENTA);
        canvas.drawText(" lives: " + lives, 50, 50 + paint.descent() - paint.ascent(), paint);
    }

    public void update(Point point) {
        rectangle.set(point.x - (rectangle.width() / 2), point.y - (rectangle.height() / 2), point.x + (rectangle.width() / 2), point.y + (rectangle.height() / 2));
        animManager.playAnim(1);
        animManager.update();
    }
}
