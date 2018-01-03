package com.example.superbobaretroplatformer;

import java.util.ArrayList;

/**
 * Created by M on 1/1/2018.
 */

public class LevelForest2 extends LevelData{

    LevelForest2() {
        tiles = new ArrayList<String>();

        this.tiles.add("666666666666666666p66666666666666666666666666666666666666666666611666666666666666666666666666666666666666666666666666666");




        // Declare the values for the teleports in order of appearance
        locations = new ArrayList<Location>();
        this.locations.add(new Location("LevelMountain2", 118f, 17f));

        backgroundDataList = new ArrayList<BackgroundData>();
        // note that speeds less than 2 cause problems
        this.backgroundDataList.add(new BackgroundData("forest", true, -1, -2, 19, 4, 20 ));
        this.backgroundDataList.add(new BackgroundData("grass", true, 1, 18, 22, 24, 4 ));
    }
}
