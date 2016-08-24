/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avectis.transportcontrol.entity;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author DPoplauski
 */
@Entity
@Table(name="cargos")
public class Cargo {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    private long cargoId;
    private int quality;
    private int weightIn;
    private int weightOut;
    private String dischargingPlace;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dischargeDate;
    private String loadingPlace;
    @Temporal(TemporalType.TIMESTAMP)
    private Date loadingDate;

    public Date getLoadingDate() {
        return loadingDate;
    }
    public void setLoadingDate(Date loadingDate) {
        if (loadingDate!=null){
            loadingDate.setTime(loadingDate.getTime()-loadingDate.getTime()%1000);
        }
        this.loadingDate = loadingDate;
    }
    public String getLoadingPlace() {
        return loadingPlace;
    }
    public void setLoadingPlace(String loadingPlace) {
        this.loadingPlace = loadingPlace;
    }
    public Date getDischargeDate() {
        return dischargeDate;
    }
    public void setDischargeDate(Date dischargeDate) {
        if (dischargeDate!=null){
            dischargeDate.setTime(dischargeDate.getTime()-dischargeDate.getTime()%1000);
        }
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

    public Cargo(int quality, int weightIn, int weightOut, String dischargingPlace, Date dischargeDate, String loadingPlace, Date loadingDate) {
        this.quality = quality;
        this.weightIn = weightIn;
        this.weightOut = weightOut;
        this.dischargingPlace = dischargingPlace;
        if (dischargeDate!=null){
            dischargeDate.setTime(dischargeDate.getTime()-dischargeDate.getTime()%1000);
        }
        this.dischargeDate = dischargeDate;
        this.loadingPlace = loadingPlace;
        if (loadingDate!=null){
            loadingDate.setTime(loadingDate.getTime()-loadingDate.getTime()%1000);
        }
        this.loadingDate = loadingDate;
    }

    @Override
    public String toString() {
        return "Cargo{" + "cargoId=" + cargoId + ", quality=" + quality + ", weightIn=" + weightIn + ", weightOut=" + weightOut + ", dischargingPlace=" + dischargingPlace + ", dischargeDate=" + dischargeDate + ", loadingPlace=" + loadingPlace + ", loadingDate=" + loadingDate + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (int) (this.cargoId ^ (this.cargoId >>> 32));
        hash = 37 * hash + this.quality;
        hash = 37 * hash + this.weightIn;
        hash = 37 * hash + this.weightOut;
        hash = 37 * hash + Objects.hashCode(this.dischargingPlace);
        hash = 37 * hash + Objects.hashCode(this.dischargeDate);
        hash = 37 * hash + Objects.hashCode(this.loadingPlace);
        hash = 37 * hash + Objects.hashCode(this.loadingDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cargo other = (Cargo) obj;
        if (this.cargoId != other.cargoId) {
            return false;
        }
        if (this.quality != other.quality) {
            return false;
        }
        if (this.weightIn != other.weightIn) {
            return false;
        }
        if (this.weightOut != other.weightOut) {
            return false;
        }
        if (!Objects.equals(this.dischargingPlace, other.dischargingPlace)) {
            return false;
        }
//        if ((this.dischargeDate==null && other.dischargeDate!=null) || this.dischargeDate!=null && other.dischargeDate==null){
//            return false;
//        }
//        if (this.dischargeDate!=null && other.dischargeDate!=null){
//            if ((!Objects.equals(this.dischargeDate.getTime()/1000, other.dischargeDate.getTime()/1000))) {
//                return false;
//            }
//        }
//        if (!Objects.equals(this.loadingPlace, other.loadingPlace)) {
//            return false;
//        }
//        if ((this.loadingDate==null && other.loadingDate!=null) || this.loadingDate!=null && other.loadingDate==null){
//            return false;
//        }
//        if (this.loadingDate!=null && other.loadingDate!=null){
//            if ((!Objects.equals(this.loadingDate.getTime()/1000, other.loadingDate.getTime()/1000))) {
//                return false;
//            }
//        }
        return true;
    }
    
}
