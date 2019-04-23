package edu.utep.cs.cs4330.dragonstikesback;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.HashMap;
import java.util.Random;

public class Action {
    private HashMap<String, Bitmap> actions;
    private int displayTime;
    private int direction;
    public int index;

    public Action() {
        BitmapFactory bf = new BitmapFactory();
        Bitmap upImg = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.up);
        Bitmap downImg = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.down);
        Bitmap leftImg = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.left);
        Bitmap rightImg = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.right);
        Bitmap defendImg = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.defend);
        Bitmap attackImg = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.attack);

        actions = new HashMap<>();
        actions.put("up", upImg);
        actions.put("down", downImg);
        actions.put("left", leftImg);
        actions.put("right", rightImg);
        actions.put("defend", defendImg);
        actions.put("attack", attackImg);
        displayTime = 1;
        index = 0;
    }

    public boolean playerMistake(Player player){
        return false;
    }

    public int getDirection() {
        return direction;
    }

    public void draw(Canvas canvas, Rect destination) {
        switch (index) {
            case 0:
                canvas.drawBitmap(actions.get("up"), null, destination, new Paint());
                direction = 0;
                break;
            case 1:
                canvas.drawBitmap(actions.get("down"), null, destination, new Paint());
                direction = 1;
                break;
            case 2:
                canvas.drawBitmap(actions.get("left"), null, destination, new Paint());
                direction = 2;
                break;
            case 3:
                canvas.drawBitmap(actions.get("right"), null, destination, new Paint());
                direction = 3;
                break;
            case 4:
                canvas.drawBitmap(actions.get("defend"), null, destination, new Paint());
                direction = 4;
                break;
            case 5:
                canvas.drawBitmap(actions.get("attack"), null, destination, new Paint());
                direction = 5;
                break;
            default:
        }
    }

    public void update() {
        index = (int) (Math.random() * 6);
    }
}
