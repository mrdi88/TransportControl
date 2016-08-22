/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avectis.transportcontrol.entity;

import java.util.Date;
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
@Table(name="cards")
public class Card {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    private long cardId;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "carId")
    private Car car;
    private long cardNumber;
    private int state;
    private int accessLevel;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public int getAccessLevel() {
        return accessLevel;
    }
    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    public long getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }
    public long getCardId() {
        return cardId;
    }
    public void setCardId(long cardId) {
        this.cardId = cardId;
    }
    public Card() {
    }

    public Card(Car car, long cardNumber, int state, int accessLevel) {
        this.car = car;
        this.cardNumber = cardNumber;
        this.state = state;
        this.accessLevel = accessLevel;
        this.createDate=new Date();
    }
    
}
