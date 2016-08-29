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
@Table(name="queues_elements")
public class TransportQueueElement {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    private long qElementId;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cardId")
    private Card card;

    public Card getCard() {
        return card;
    }
    public void setCard(Card card) {
        this.card = card;
    }
    public long getqElementId() {
        return qElementId;
    }
    public void setqElementId(long qElementId) {
        this.qElementId = qElementId;
    }
    public TransportQueueElement() {
    }

    public TransportQueueElement(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "TransportQueueElement{" + "qElementId=" + qElementId + ", card=" + card + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final TransportQueueElement other = (TransportQueueElement) obj;
        if (this.qElementId != other.qElementId) {
            return false;
        }
        if (!Objects.equals(this.card, other.card)) {
            return false;
        }
        return true;
    }
    
}
