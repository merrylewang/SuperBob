package com.example.superbobaretroplatformer;

import android.graphics.PointF;

/**
 * Created by M on 12/29/2017.
 */

public class PlayerState {
    private int numCredits;
    private int mgFireRate;
    private int lives;
    private float restartX;
    private float restartY;

    PlayerState() {
        lives = 1000000;
        mgFireRate = 1;
        numCredits = 0;
    }

    public void saveLocation(PointF location){
        restartX = location.x;
        restartY = location.y;
    }

    public PointF loadLocation(){
        return new PointF(restartX, restartY);
    }
    public int getLives(){
        return lives;
    }

    public int getFireRate(){
        return mgFireRate;
    }

    public void increaseFireRate(){
        mgFireRate += 2;
    }

    public void gotCredit(){
        numCredits ++;
    }

    public int getCredits(){
        return numCredits;
    }

    public void loseLife(){
        lives--;
    }

    public void addLife(){
        lives++;
    }

    public void resetLives(){
        lives = 3;
    }
    public void resetCredits(){
        lives = 0;
    }
}
