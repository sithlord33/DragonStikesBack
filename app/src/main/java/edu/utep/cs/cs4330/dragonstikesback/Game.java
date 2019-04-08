package edu.utep.cs.cs4330.dragonstikesback;

import java.util.LinkedList;
import java.util.Queue;

public class Game {
    private boolean win;
    private Queue<Integer> sequence;

    Game(int size) {
        win = false;
        sequence = new LinkedList<>();

        for (int i = 0; i < size; i++)
            sequence.add((int) (Math.random() * 6));
    }

    public int nextInstruction() {
        return sequence.remove();
    }

    public boolean isWin() {
        if (sequence.isEmpty())
            return true;
        return false;
    }
}
