package edu.utep.cs.cs4330.dragonstikesback;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;

public class ActionManager {
    private ArrayList<Action> actions;
    private int playerGap;
    private int obstacleGap;
    private int obstacleHeight;
    private int color;

    private long startTime;
    private long initTime;

    private int score = 0;

    public ActionManager(int playerGap, int obstacleGap, int obstacleHeight, int color) {
        this.playerGap = playerGap;
        this.obstacleGap = obstacleGap;
        this.obstacleHeight = obstacleHeight;
        this.color = color;

        startTime = initTime = System.currentTimeMillis();

        actions = new ArrayList<>();

        //populateObstacles();
    }

    public boolean playerMistake(Player player) {
        for (Action a : actions)
            if (a.playerMistake(player))
                return true;
        return false;
    }


    /*public void update() {
        if(startTime < Constants.INIT_TIME)
            startTime = Constants.INIT_TIME;
        int elapsedTime = (int) (System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();
        float speed = (float) Math.sqrt(1 + (startTime - initTime) / 2000) * Constants.SCREEN_HEIGHT / (10000.0f);
        for (Obstacle ob : obstacles)
            ob.incrementY(speed * elapsedTime);
        if (obstacles.get(obstacles.size() - 1).getRectangle().top >= Constants.SCREEN_HEIGHT) {
            int xStart = (int) (Math.random() * (Constants.SCREEN_WIDTH - playerGap));
            int yStart = obstacles.get(0).getRectangle().top - obstacleHeight - obstacleGap;
            obstacles.add(0, new Obstacle(obstacleHeight, color, xStart, yStart, playerGap));
            obstacles.remove(obstacles.size() - 1);
            score++;
        }
    }*/

    /*public void draw(Canvas canvas) {
        for (Obstacle ob : obstacles)
            ob.draw(canvas);
        Paint paint = new Paint();
        paint.setTextSize(100);
        paint.setColor(Color.MAGENTA);
        canvas.drawText("" + score, 50, 50 + paint.descent() - paint.ascent(), paint);
    }*/
}