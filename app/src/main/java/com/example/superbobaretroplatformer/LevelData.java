package com.example.superbobaretroplatformer;

import java.util.ArrayList;

/**
 * Created by M on 12/28/2017.
 */

public class LevelData {
    ArrayList<String> tiles;
    ArrayList<BackgroundData> backgroundDataList;
    ArrayList<Location> locations;

        // Tile types
        // . = no tile
        // 1 = Grass
        // 2 = Snow
        // 3 = Brick
        // 4 = Coal
        // 5 = Concrete
        // 6 = Scorched
        // 7 = Stone

        //Active objects
        // g = guard
        // d = drone
        // t = teleport
        // c = coin
        // u = upgrade
        // f = fire
        // e  = extra life

        //Inactive objects
        // w = tree
        // x = tree2 (snowy)
        // l = lampost
        // r = stalactite
        // s = stalacmite
        // m = mine cart
        // z = boulders
}
