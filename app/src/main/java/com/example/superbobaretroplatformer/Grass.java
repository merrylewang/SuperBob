package com.example.superbobaretroplatformer;

/**
 * Created by M on 12/28/2017.
 */

public class Grass extends GameObject {
    Grass(float worldStartX, float worldStartY, char type){
        setTraversable();

        final float HEIGHT = 1;
        final float WIDTH = 1;

        setHeight(HEIGHT);
        setWidth(WIDTH);

        setType(type);

        setBitmapName("turf");

        setWorldLocation(worldStartX, worldStartY, 0);
        setRectHitbox();
    }

    public void update(long fps, float gravity){}
}
