package edu.utep.cs.cs4330.dragonstikesback;

public class Player {
    private int lives;
    private boolean dead;

    Player() {
        dead = false;
        lives = 5;
    }

    public boolean isDead() {
        if (this.lives <= 0) {
            dead = true;
            return true;
        }
        return false;
    }
}
