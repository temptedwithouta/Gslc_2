package com.example.gslc_2;

public class University {
    private String name = "BINUS";

    private String location;

    private String latitude;

    private String longitude;

    public University(String location, String latitude, String longitude){
        this.location = location;

        this.latitude = latitude;

        this.longitude = longitude;
    }

    public String getName(){
        return this.name;
    }

    public String getLocation(){
        return this.location;
    }

    public String getLatitude(){
        return this.latitude;
    }

    public String getLongitude(){
        return this.longitude;
    }
}
