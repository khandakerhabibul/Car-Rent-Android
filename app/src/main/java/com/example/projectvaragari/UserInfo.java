package com.example.projectvaragari;


import com.google.firebase.database.Exclude;

public class UserInfo {
    String carId;
    String drivername;
    String carmodel;
    String stnumber;
    String drvphnnumber;
    String garivara;

    public UserInfo(){

    }

    public UserInfo(String carId, String drivername, String carmodel, String stnumber , String drvphnnumber , String garivara){
        this.carId = carId;
        this.drivername = drivername;
        this.carmodel = carmodel;
        this.stnumber = stnumber;
        this.drvphnnumber = drvphnnumber;
        this.garivara = garivara;
    }


    @Exclude
    public String getCarId() {
        return carId;
    }


    @Exclude
    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    public String getCarmodel() {
        return carmodel;
    }

    public void setCarmodel(String carmodel) {
        this.carmodel = carmodel;
    }

    public String getStnumber() {
        return stnumber;
    }

    public void setStnumber(String stnumber) {
        this.stnumber = stnumber;
    }

    public String getDrvphnnumber() {
        return drvphnnumber;
    }

    public void setDrvphnnumber(String drvphnnumber) {
        this.drvphnnumber = drvphnnumber;
    }

    public String getGarivara() {
        return garivara;
    }

    public void setGarivara(String garivara) {
        this.garivara = garivara;
    }
}
