package com.example.superbobaretroplatformer;

import android.content.Context;

/**
 * Created by M on 12/28/2017.
 */

public class Player extends GameObject {

    final float MAX_X_VELOCITY = 10;
    boolean isPressingRight = false;
    boolean isPressingLeft = false;

    public boolean isFalling;
    private boolean isJumping;
    private long jumpTime;
    private long maxJumpTime = 700;

    RectHitbox rectHitboxFeet;
    RectHitbox rectHitboxHead;
    RectHitbox rectHitboxLeft;
    RectHitbox rectHitboxRight;

    public MachineGun bfg;

    Player(Context context, float worldStartX,
           float worldStartY, int pixelsPerMeter) {

        final float HEIGHT = 2;
        final float WIDTH = 1;

        setHeight(HEIGHT);
        setWidth(WIDTH);

        //Standing still to start with
        setxVelocity(0);
        setyVelocity(0);
        setFacing(LEFT);
        isFalling = false;

        //Now for the player's other attributes
        //Our game engine will use these
        setMoves(true);
        setActive(true);
        setVisible(true);
        // ...

        setType('p');

        // Choose a Bitmap
        // This is a sprite sheet with multiple frames
        // of animation. So it will look silly until we animate it
        // In chapter 6.

        setBitmapName("player");

        final int ANIMATION_FPS = 16;
        final int ANIMATION_FRAME_COUNT = 5;

        //sets up animations
        setAnimFps(ANIMATION_FPS);
        setAnimFrameCount(ANIMATION_FRAME_COUNT);
        setAnimated(context,pixelsPerMeter,true);


        setWorldLocation(worldStartX, worldStartY, 0);

        rectHitboxFeet = new RectHitbox();
        rectHitboxHead = new RectHitbox();
        rectHitboxLeft = new RectHitbox();
        rectHitboxRight = new RectHitbox();

        bfg = new MachineGun();
    }

    public void update(long fps, float gravity) {
        //direction
        if (isPressingRight){
            this.setxVelocity(MAX_X_VELOCITY);
        } else if (isPressingLeft){
            this.setxVelocity(-MAX_X_VELOCITY);
        } else {
            this.setxVelocity(0);
        }

        // the way bob is facing
        if (this.getxVelocity() > 0){
            setFacing(RIGHT);
        } else if(this.getxVelocity() < 0){
            setFacing(LEFT);
        }// if 0 stays unchanged

        //jumping
        if (isJumping){
            long timeJumping = System.currentTimeMillis() - jumpTime;
            if (timeJumping < maxJumpTime){
                if(timeJumping < maxJumpTime / 2){
                    this.setyVelocity(-gravity);
                } else if (timeJumping > maxJumpTime / 2){
                    this.setyVelocity(gravity);
                }
            } else {
                isJumping = false;
            }
        } else {
                this.setyVelocity(gravity);
                // Read Me!
                // Remove this next line to make the game easier
                // it means the long jumps are less punishing
                // because the player can take off just after the platform
                // They will also be able to cheat by jumping in thin air
                isFalling = true;
        }

        //update gun
        bfg.update(fps,gravity);

        //changing coordinates
        this.move(fps);

        //updating all 4 hitboxes
        Vector2Point5D location = getWorldLocation();
        float lx = location.x;
        float ly = location.y;

        //NOTE: scalars are to account for all of the animation frames
        //update the player feet hitbox
        rectHitboxFeet.top = ly + getHeight() * .95f;
        rectHitboxFeet.left = lx + getWidth() * .2f;
        rectHitboxFeet.bottom = ly + getHeight() * .98f;
        rectHitboxFeet.right = lx + getWidth() * .8f;

        // Update player head hitbox
        rectHitboxHead.top = ly;
        rectHitboxHead.left = lx + getWidth() * .4f;
        rectHitboxHead.bottom = ly + getHeight() * .2f;
        rectHitboxHead.right = lx + getWidth() * .6f;

        // Update player left hitbox
        rectHitboxLeft.top = ly + getHeight() * .2f;
        rectHitboxLeft.left = lx + getWidth() * .2f;
        rectHitboxLeft.bottom = ly + getHeight() * .8f;
        rectHitboxLeft.right = lx + getWidth() * .3f;

        // Update player right hitbox
        rectHitboxRight.top = ly + getHeight() * .2f;
        rectHitboxRight.left = lx + getWidth() * .8f;
        rectHitboxRight.bottom = ly + getHeight() * .8f;
        rectHitboxRight.right = lx + getWidth() * .7f;

    } //end of update()

    public int checkCollisions(RectHitbox rectHitbox){
        int collided = 0; //when there's no collision

        //LEFT
        if(this.rectHitboxLeft.intersects(rectHitbox)){
            this.setWorldLocationX(rectHitbox.right - getWidth() * .2f);
            collided = 1;
        }
        //RIGHT
        if (this.rectHitboxRight.intersects(rectHitbox)) {
            this.setWorldLocationX(rectHitbox.left - getWidth() * .8f);
            collided = 1;
        }

        //FEET
        if (this.rectHitboxFeet.intersects(rectHitbox)) {
            this.setWorldLocationY(rectHitbox.top - getHeight());
            collided = 2;
        }

        //HEAD
        if (this.rectHitboxHead.intersects(rectHitbox)) {
            this.setWorldLocationY(rectHitbox.bottom);
            collided = 3;
        }

        return collided;
    }

    public void setPressingRight(boolean isPressingRight){
        this.isPressingRight = isPressingRight;
    }
    public void setPressingLeft(boolean isPressingLeft){
        this.isPressingLeft = isPressingLeft;
    }
    public void startJump(SoundManager sm){
        if(!isFalling){
            if(!isJumping){
                isJumping = true;
                jumpTime = System.currentTimeMillis();
                sm.playSound("jump");
            }
        }
    }

    public boolean pullTrigger(){
        return bfg.shoot(this.getWorldLocation().x,this.getWorldLocation().y,
                            getFacing(), getHeight());
    }

    public void restorePreviousVelocity(){
        if(!isJumping && !isFalling){
            if(getFacing() == LEFT){
                isPressingLeft = true;
                setxVelocity(-MAX_X_VELOCITY);
            } else {
                isPressingRight = true;
                setxVelocity(MAX_X_VELOCITY);
            }
        }
    }
}
