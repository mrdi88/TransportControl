/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avectis.transportcontrol.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Dima
 */
public class QueueView {

    private long id;
    private String name;
    private List<CardView> cards=new ArrayList<>();
    
    public List<CardView> getCards() {
        return cards;
    }
    public void setCards(List<CardView> cards) {
        this.cards = cards;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public QueueView() {
    }

    public QueueView(String name, List<CardView> cards) {
        this.name = name;
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "TransportQueue{" + "queueId=" + id + ", name=" + name + ", qElements=" + cards + '}';
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
        final QueueView other = (QueueView) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.cards, other.cards)) {
            return false;
        }
        return true;
    }
    
}

