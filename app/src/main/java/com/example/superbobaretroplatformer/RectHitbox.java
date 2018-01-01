package com.example.superbobaretroplatformer;

/**
 * Created by M on 12/29/2017.
 */

public class RectHitbox {
    float top;
    float left;
    float bottom;
    float right;
    float height;

    boolean intersects(RectHitbox rectHitbox){
        boolean hit = false;
        if (this.right > rectHitbox.left && this.left < rectHitbox.right){
            if (this.top < rectHitbox.bottom && this.bottom > rectHitbox.top){
                hit = true;
            }
        }
        return hit;
    }

    //getters and setters
    public void setTop(float top){
        this.top = top;
    }
    public float getLeft(){
        return left;
    }
    public void setLeft(float left){
        this.left = left;
    }
    public void setBottom(float bottom){
        this.bottom = bottom;
    }
    public float getRight(){
        return right;
    }
    public void setRight(float right){
        this.right = right;
    }
    public float getHeight(){
        return height;
    }
    public void setHeight(float height){
        this.height = height;
    }

}
