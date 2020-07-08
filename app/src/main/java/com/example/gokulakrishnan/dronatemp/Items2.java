package com.example.gokulakrishnan.dronatemp;

/**
 * Created by Gokulakrishnan on 7/7/2020.
 */

class Items2 {
//    public static char[] getWhLocation;
    public  String sh_Location;
    public  String wh_Location;

    public Items2(String sh_location, String wh_location) {
        this.wh_Location=wh_location;
        this.sh_Location=sh_location;
    }
    public String getWh_Location(){
        return wh_Location;
    }
    public String getSh_Location(){
        return sh_Location;
    }

}
