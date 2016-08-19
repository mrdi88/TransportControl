/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avectis.transportcontrol.entity;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author DPoplauski
 */
@Entity
@Table(name = "drivers")
public class Driver {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy="increment")
    private long driverId;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "carId")
    private Car car;
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
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }
    public Driver() {
    }

    @Override
    public String toString() {
        return "Driver{" + "driverId=" + driverId + ", name=" + name + ", mobileNumber=" + mobileNumber + ", organization=" + organization + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (int) (this.driverId ^ (this.driverId >>> 32));
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + Objects.hashCode(this.mobileNumber);
        hash = 71 * hash + Objects.hashCode(this.organization);
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
        final Driver other = (Driver) obj;
        if (this.driverId != other.driverId) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.mobileNumber, other.mobileNumber)) {
            return false;
        }
        if (!Objects.equals(this.organization, other.organization)) {
            return false;
        }
        return true;
    }
    
}
