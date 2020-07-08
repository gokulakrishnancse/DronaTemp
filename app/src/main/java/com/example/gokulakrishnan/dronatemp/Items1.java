package com.example.gokulakrishnan.dronatemp;

/**
 * Created by Gokulakrishnan on 7/7/2020.
 */

class Items1 {
    int imageicon;
    private String flt_num;
    private String airLine_code_num;
    private String apt_brd;
    public Items1(int imageicon,String flt_num, String airLine_code_num,String apt_brd) {
        this.flt_num=flt_num;
        this.airLine_code_num=airLine_code_num;
        this.apt_brd=apt_brd;
        this.imageicon=imageicon;
    }
    public String getflt_num() {
        return flt_num;
    }

    public String getairLine_code_num() {
        return airLine_code_num;
    }
    public String getApt_brd(){
        return apt_brd;
    }
    public int getImageicon(){
        return imageicon;
    }


}
