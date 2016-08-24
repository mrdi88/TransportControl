/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avectis.transportcontrol.entity;

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
@Table(name="queues_elements")
public class TransportQueueElement {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    private long qElementId;
    private int orderNumber;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cardId")
    private Card card;

    public Card getCard() {
        return card;
    }
    public void setCard(Card card) {
        this.card = card;
    }
    public int getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    public long getqElementId() {
        return qElementId;
    }
    public void setqElementId(long qElementId) {
        this.qElementId = qElementId;
    }
    public TransportQueueElement() {
    }

    public TransportQueueElement(int orderNumber, Card card) {
        this.orderNumber = orderNumber;
        this.card = card;
    }

    @Override
    public String toString() {
        return "TransportQueueElement{" + "qElementId=" + qElementId + ", orderNumber=" + orderNumber + ", card=" + card + '}';
    }
    
}
