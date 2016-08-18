/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avectis.transportcontrol.entity;

/**
 *
 * @author DPoplauski
 */
public class Driver {

    private long driverId;
    private String name;
    private String mobileNumber;
    private String organization;

    public Driver(String name, String mobileNumber, String organization) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.organization = organization;
    }

    public String getOrganization() {
        return organization;
    }
    public void setOrganization(String organization) {
        this.organization = organization;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getDriverId() {
        return driverId;
    }
    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }
    public Driver() {
    }
}
