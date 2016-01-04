package com.minespazio.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;

/**
 * Created by cacho on 03/01/2016.
 */
public class Locations {


    //Utilizada para guardas locations en configs
    public String setLoc(Location loc, boolean pitch) {
        if (pitch == true) {
            return loc.getWorld().getName() + "," + loc.getBlockX() + "," + loc.getBlockY() + "," + loc.getBlockZ() + "," + loc.getYaw() + "," + loc.getPitch();
        }
        return loc.getWorld().getName() + "," + loc.getBlockX() + "," + loc.getBlockY() + "," + loc.getBlockZ();
    }
    // + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // +


   //Utilizada para obtener locations de configs
    public Location getLoc(String path, boolean pitch) {
        Location loc = null;
        if (!pitch) {
            String[] locs = path.split(",");

            loc = new Location(Bukkit.getWorld(locs[0]), Integer.parseInt(locs[1]), Integer.parseInt(locs[2]), Integer.parseInt(locs[3]));
            loc.add(0.5D, 0.0D, 0.5D);
            return loc;
        }
        String[] locs = path.split(",");
        loc = new Location(Bukkit.getWorld(locs[0]), Integer.parseInt(locs[1]), Integer.parseInt(locs[2]), Integer.parseInt(locs[3]), Float.valueOf(locs[4]).floatValue(), Float.valueOf(locs[5]).floatValue());
        loc.add(0.5D, 0.0D, 0.5D);
        return loc;
    }
    // + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // +

}
