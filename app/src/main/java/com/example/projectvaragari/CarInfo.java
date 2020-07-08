package com.example.projectvaragari;

import com.google.firebase.database.Exclude;

public class CarInfo {
    String carId;
    String drivername;
    String carmodel;
    String stnumber;
    String drvphnnumber;
    String garivara;

    public CarInfo(){

    }


    public CarInfo(String carId, String drivername, String carmodel, String stnumber , String drvphnnumber , String garivara) {
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

    public String getDrivername() {
        return drivername;
    }

    public String getCarmodel() {
        return carmodel;
    }

    public String getStnumber() {
        return stnumber;
    }

    public String getDrvphnnumber() {
        return drvphnnumber;
    }

    public String getGarivara() {
        return garivara;
    }

    @Exclude
    public void setCarId(String carId) {
        this.carId = carId;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    public void setCarmodel(String carmodel) {
        this.carmodel = carmodel;
    }

    public void setStnumber(String stnumber) {
        this.stnumber = stnumber;
    }

    public void setDrvphnnumber(String drvphnnumber) {
        this.drvphnnumber = drvphnnumber;
    }

    public void setGarivara(String garivara) {
        this.garivara = garivara;
    }


}
