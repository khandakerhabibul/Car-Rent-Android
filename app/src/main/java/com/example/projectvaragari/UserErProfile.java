package com.example.projectvaragari;

public class UserErProfile {
    String userID;
    String email;
    String driverName;
    String carmodel;
    String seat;
    String DriverPhnNumber;
    String gariVara;

    public UserErProfile(){

    }


    public UserErProfile(String userID, String email, String driverName, String carmodel, String seat, String driverPhnNumber, String gariVara) {
        this.userID = userID;
        this.email = email;
        this.driverName = driverName;
        this.carmodel = carmodel;
        this.seat = seat;
        DriverPhnNumber = driverPhnNumber;
        this.gariVara = gariVara;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getCarmodel() {
        return carmodel;
    }

    public void setCarmodel(String carmodel) {
        this.carmodel = carmodel;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getDriverPhnNumber() {
        return DriverPhnNumber;
    }

    public void setDriverPhnNumber(String driverPhnNumber) {
        DriverPhnNumber = driverPhnNumber;
    }

    public String getGariVara() {
        return gariVara;
    }

    public void setGariVara(String gariVara) {
        this.gariVara = gariVara;
    }
}
