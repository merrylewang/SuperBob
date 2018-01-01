package com.example.superbobaretroplatformer;

import android.graphics.Rect;

/**
 * Created by M on 12/28/2017.
 */

public class Viewport {
    private Vector2Point5D currentViewportWorldCenter;
    private Rect convertedRect;
    private int pixelsPerMeterX;
    private int pixelsPerMeterY;
    private int screenXResolution;
    private int screenYResolution;
    private int screenCenterX;
    private int screenCenterY;
    private int metersToShowX;
    private int metersToShowY;
    private int numClipped;

    Viewport(int x, int y){
        screenXResolution = x;
        screenYResolution = y;

        screenCenterX = screenXResolution / 2;
        screenCenterY = screenYResolution / 2;

        pixelsPerMeterX = screenXResolution / 32;
        pixelsPerMeterY = screenYResolution / 18;

        metersToShowX = 34;
        metersToShowY = 20;

        convertedRect = new Rect();
        currentViewportWorldCenter = new Vector2Point5D();
    }

    void setWorldCenter(float x, float y){
        currentViewportWorldCenter.x = x;
        currentViewportWorldCenter.y = y;
    }
    public int getPixelsPerMeterY(){
        return pixelsPerMeterY;
    }
    public int getyCenter(){
        return screenCenterY;
    }
    public float getViewportWorldCenterY(){
        return currentViewportWorldCenter.y;
    }
    //some getters and setters
    public int getScreenWidth(){
        return screenXResolution;
    }
    public int getScreenHeight(){
        return screenYResolution;
    }
    public int getPixelsPerMeterX(){
        return pixelsPerMeterX;
    }
    public Rect worldToScreen(
            float objectX,
            float objectY,
            float objectWidth,
            float objectHeight){

        int left = (int) (screenCenterX -
                ((currentViewportWorldCenter.x - objectX)
                        * pixelsPerMeterX));

        int top =  (int) (screenCenterY -
                ((currentViewportWorldCenter.y - objectY)
                        * pixelsPerMeterY));

        int right = (int) (left +
                (objectWidth *
                        pixelsPerMeterX));

        int bottom = (int) (top +
                (objectHeight *
                        pixelsPerMeterY));

        convertedRect.set(left, top, right, bottom);

        return convertedRect;
    }

    public boolean clipObjects(float objectX, float objectY, float objectWidth, float objectHeight){
        boolean clipped = true;
        if (objectX - objectWidth < currentViewportWorldCenter.x + (metersToShowX / 2)) {
            if (objectX + objectWidth > currentViewportWorldCenter.x - (metersToShowX / 2)){
                if (objectY - objectHeight < currentViewportWorldCenter.y + (metersToShowY / 2)){
                    if(objectY + objectHeight > currentViewportWorldCenter.y - (metersToShowY / 2)){
                        clipped = false;
                    }
                }
            }
        }
        //for debugging
        if(clipped){
            numClipped++;
        }
        return clipped;
    }
    public int getNumClipped(){
        return numClipped;
    }
    public void resetNumClipped(){
        numClipped = 0;
    }
    public void moveViewportRight(int maxWidth){
        if(currentViewportWorldCenter.x < maxWidth -
                (metersToShowX/2)+3) {

            currentViewportWorldCenter.x += 1;
        }
    }

    public void moveViewportLeft(){
        if(currentViewportWorldCenter.x > (metersToShowX/2)-3){
            currentViewportWorldCenter.x -= 1;
        }
    }

    public void moveViewportUp(){
        if(currentViewportWorldCenter.y > (metersToShowY /2)-3) {
            currentViewportWorldCenter.y -= 1;
        }
    }

    public void moveViewportDown(int maxHeight){
        if(currentViewportWorldCenter.y <
                maxHeight - (metersToShowY / 2)+3) {

            currentViewportWorldCenter.y += 1;
        }
    }
}//End of Viewport
