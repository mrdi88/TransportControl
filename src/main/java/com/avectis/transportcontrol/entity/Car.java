/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avectis.transportcontrol.entity;

import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author DPoplauski
 */
@Entity
@Table(name="cars")
public class Car {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    private long carId;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "cargoId")
    private Cargo cargo;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "driverId")
    private Driver driver;
    private String destination;
    private String firstNumber;
    private String secondNumber;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date leaveDate;

    public Date getLeaveDate() {
        return leaveDate;
    }
    public void setLeaveDate(Date leaveDate) {
        if(leaveDate!=null){
            leaveDate.setTime(leaveDate.getTime()-leaveDate.getTime()%1000);
        }
        
        this.leaveDate = leaveDate;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        if(createDate!=null){
            createDate.setTime(createDate.getTime()-createDate.getTime()%1000);
        }
        this.createDate = createDate;
    }
    public String getSecondNumber() {
        return secondNumber;
    }
    public void setSecondNumber(String secondNumber) {
        this.secondNumber = secondNumber;
    }
    public String getFirstNumber() {
        return firstNumber;
    }
    public void setFirstNumber(String firstNumber) {
        this.firstNumber = firstNumber;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public Driver getDriver() {
        return driver;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }
    public Cargo getCargo() {
        return cargo;
    }
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    public long getCarId() {
        return carId;
    }
    public void setCarId(long carId) {
        this.carId = carId;
    }
    public Car() {
    }

    public Car(Cargo cargo, Driver driver, String destination, String firstNumber, String secondNumber) {
        this.cargo = cargo;
        this.driver = driver;
        this.destination = destination;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        Date dt=new Date();
        dt.setTime(dt.getTime()-dt.getTime()%1000);
        this.createDate = dt;
    }

    @Override
    public String toString() {
        return "Car{" + "carId=" + carId + ", cargo=" + cargo + ", driver=" + driver + ", destination=" + destination + ", firstNumber=" + firstNumber + ", secondNumber=" + secondNumber + ", createDate=" + createDate + ", leaveDate=" + leaveDate + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (this.carId ^ (this.carId >>> 32));
        hash = 67 * hash + Objects.hashCode(this.cargo);
        hash = 67 * hash + Objects.hashCode(this.driver);
        hash = 67 * hash + Objects.hashCode(this.destination);
        hash = 67 * hash + Objects.hashCode(this.firstNumber);
        hash = 67 * hash + Objects.hashCode(this.secondNumber);
        hash = 67 * hash + Objects.hashCode(this.createDate);
        hash = 67 * hash + Objects.hashCode(this.leaveDate);
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
        final Car other = (Car) obj;
        if (this.carId != other.carId) {
            return false;
        }
        if (!Objects.equals(this.cargo, other.cargo)) {
            return false;
        }
        if (!Objects.equals(this.driver, other.driver)) {
            return false;
        }
        if (!Objects.equals(this.destination, other.destination)) {
            return false;
        }
        if (!Objects.equals(this.firstNumber, other.firstNumber)) {
            return false;
        }
        if (!Objects.equals(this.secondNumber, other.secondNumber)) {
            return false;
        }
        if ((!Objects.equals(this.createDate, other.createDate))) {
                return false;
        }
        if ((!Objects.equals(this.leaveDate, other.leaveDate))) {
                return false;
        }
        return true;
    }
}
