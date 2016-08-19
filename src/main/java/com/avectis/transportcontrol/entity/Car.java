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
    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Cargo cargo;
    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
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
        this.leaveDate = leaveDate;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
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

    public Car(Cargo cargo, Driver driver, String destination, String firstNumber, String secondNumber, Date createDate, Date leaveDate) {
        this.cargo = cargo;
        this.driver = driver;
        this.destination = destination;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.createDate = createDate;
        this.leaveDate = leaveDate;
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
        if ((this.createDate==null && other.createDate!=null) || this.createDate!=null && other.createDate==null){
            return false;
        }
        if (this.createDate!=null && other.createDate!=null){
            if ((!Objects.equals(this.createDate.getTime()/1000, other.createDate.getTime()/1000))) {
                return false;
            }
        }
        if ((this.leaveDate==null && other.leaveDate!=null) || this.leaveDate!=null && other.leaveDate==null){
            return false;
        }
        if (this.leaveDate!=null && other.leaveDate!=null){
            if ((!Objects.equals(this.leaveDate.getTime()/1000, other.leaveDate.getTime()/1000))) {
                return false;
            }
        }
        return true;
    }
    
}
