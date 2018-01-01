package com.example.superbobaretroplatformer;

/**
 * Created by M on 12/30/2017.
 */

public class BackgroundData {
    String bitmapName;
    boolean isParallax;
    int layer;
    float startY;
    float endY;
    float speed;
    int height;
    int width;

    BackgroundData(String bitmap, boolean isParallax, int layer, float startY,
                   float endY, float speed, int height){
        this.bitmapName = bitmap;
        this.isParallax = isParallax;
        this.layer = layer;
        this.startY = startY;
        this.endY = endY;
        this.speed = speed;
        this.height = height;
    }
}
