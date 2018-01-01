package com.example.superbobaretroplatformer;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;

public class PlatformActivity extends Activity {
    private PlatformView platformView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Display display = getWindowManager().getDefaultDisplay();
        Point resolution = new Point();
        display.getSize(resolution);
        platformView = new PlatformView(this, resolution.x, resolution.y);
        setContentView(platformView);
    }

    @Override
    protected void onPause(){
        super.onPause();
        platformView.pause();
    }

    @Override
    protected void onResume(){
        super.onResume();
        platformView.resume();
    }
}