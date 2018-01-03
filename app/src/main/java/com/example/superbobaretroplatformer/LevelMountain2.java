package com.example.superbobaretroplatformer;

import java.util.ArrayList;

/**
 * Created by M on 1/1/2018.
 */

public class LevelMountain2 extends LevelData{

    //A level with one fixed parallax background

    LevelMountain2() {
        tiles = new ArrayList<String>();
        this.tiles.add("p................................................................................................2222222222222...........");
        this.tiles.add("................................e...e....e..............ccccccccccccccccccccccccccccccc.......................ff.........");
        this.tiles.add(".........................e......2...2....2.............66666666666666666666666666666666........2...............ff.......f");
        this.tiles.add(".........................2......ffffffffff....e.......6.........................................................f.......f");
        this.tiles.add("............................ee................2......6...................................2....2..................f...t..f");
        this.tiles.add("............................22...................f......fffffffffffffffffff.......2.............................f.......f");
        this.tiles.add(".......c...................c.....................2..............................................................fffffffff");
        this.tiles.add(".......2...................2.....ccccccccccc....................................2.fffffffffffff..........................");
        this.tiles.add("..e.......................e..........................f...................................................................");
        this.tiles.add("..2.......................2..........................2.......................2.fff.........................ffffffffff....");
        this.tiles.add("..f....e.....e...e..e...e.....ffffffffffffffff..........f..................................................f44444444f....");
        this.tiles.add(".......2f....2f..2f.2...2...............................2.................2.fff............................f4ffffff4f....");
        this.tiles.add(".....e.e.............f......................................f..f..ffffff...................................f44444444f....");
        this.tiles.add(".....2.2....................................................2..2..222222...................................ffffffffff....");
        this.tiles.add(".....f...................................................................................................................");
        this.tiles.add(".2....x....2x.2....x.........x..........x.................x..............x..........x.........x........x.................");
        this.tiles.add(".f.......................................................................................................................");
        this.tiles.add("...2....2............ecu......................llllllllllllllllllllllllllllllllllllllllll.................................");
        this.tiles.add("....f...f....xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxccccccccccccccccccccccccccccccccccccccccccxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        this.tiles.add("222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222.");

        // Declare the values for the teleports in order of appearance
        locations = new ArrayList<Location>();
        this.locations.add(new Location("LevelCave", 1f, 16f));

        backgroundDataList = new ArrayList<BackgroundData>();
        this.backgroundDataList.add(new BackgroundData("mountain", true, -2, -5, 6, 4, 11 ));
        this.backgroundDataList.add(new BackgroundData("mountainside", true, -1, 6, 20, 8, 14 ));
        this.backgroundDataList.add(new BackgroundData("grass", true, 1,19, 23, 16, 4 ));
    }
}
