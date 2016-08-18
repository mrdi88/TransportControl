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
public class Cargo {

    private long cargoId;
    private int quality;
    private int weightIn;
    private int weightOut;
    private String dischargingPlace;
    private String dischargeDate;
    private String loadingPlace;
    private String loadingDate;

    public String getLoadingDate() {
        return loadingDate;
    }
    public void setLoadingDate(String loadingDate) {
        this.loadingDate = loadingDate;
    }
    public String getLoadingPlace() {
        return loadingPlace;
    }
    public void setLoadingPlace(String loadingPlace) {
        this.loadingPlace = loadingPlace;
    }
    public String getDischargeDate() {
        return dischargeDate;
    }
    public void setDischargeDate(String dischargeDate) {
        this.dischargeDate = dischargeDate;
    }
    public String getDischargingPlace() {
        return dischargingPlace;
    }
    public void setDischargingPlace(String dischargingPlace) {
        this.dischargingPlace = dischargingPlace;
    }
    public int getWeightOut() {
        return weightOut;
    }
    public void setWeightOut(int weightOut) {
        this.weightOut = weightOut;
    }
    public int getWeightIn() {
        return weightIn;
    }
    public void setWeightIn(int weightIn) {
        this.weightIn = weightIn;
    }
    public int getQuality() {
        return quality;
    }
    public void setQuality(int quality) {
        this.quality = quality;
    }
    public long getCargoId() {
        return cargoId;
    }
    public void setCargoId(long cargoId) {
        this.cargoId = cargoId;
    }
    
    public Cargo() {
    }
}
