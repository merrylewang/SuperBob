package com.example.superbobaretroplatformer;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by M on 12/29/2017.
 */

public class MachineGun extends GameObject{
    private int maxBullets = 10;
    private int numBullets;
    private int nextBullet;
    private int rateOfFire = 1;
    private long lastShotTime;

    private CopyOnWriteArrayList<Bullet> bullets;

    int speed = 25;

    //constructor
    MachineGun(){
        bullets = new CopyOnWriteArrayList<Bullet>();
        lastShotTime = -1;
        nextBullet = -1;
    }

    public void update(long fps, float gravity){
        for (Bullet bullet: bullets){
            bullet.update(fps, gravity);
        }
    }

    public int getRateOfFire(){
        return rateOfFire;
    }
    public void setFireRate(int rate){
        rateOfFire = rate;
    }
    public int getNumBullets(){
            return numBullets;
    }
    public float getBulletX(int bulletIndex){
        if(bullets != null && bulletIndex < numBullets){
            return bullets.get(bulletIndex).getX();
        }

        return -1f;
    }
    public float getBulletY(int bulletIndex){
        if(bullets != null){
            return bullets.get(bulletIndex).getY();
        }

        return -1f;
    }

    public void hideBullet(int index){
        bullets.get(index).hideBullet();
    }
    public int getDirection(int index){
        return bullets.get(index).getDirection();
    }

    //shoots a bullet
    public boolean shoot(float ownerX, float ownerY, int ownerFacing, float ownerHeight){
        boolean shotFired = false;
        if(System.currentTimeMillis() - lastShotTime > 1000 / rateOfFire){
            nextBullet++;
            if(numBullets >= maxBullets){
                numBullets = maxBullets;
            }
            if(nextBullet == maxBullets){
                nextBullet = 0;
            }

            lastShotTime = System.currentTimeMillis();
            bullets.add(nextBullet, new Bullet(ownerX,ownerY + ownerHeight / 3, speed, ownerFacing));
            shotFired = true;
            numBullets++;
        }
        return shotFired;
    }

    public void upgradeRateOfFire(){
        rateOfFire += 2;
    }


}
