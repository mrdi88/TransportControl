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
public class TransportQueueElement {

    private long qElementId;
    private int orderNumber;
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
}
