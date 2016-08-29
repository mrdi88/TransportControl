/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avectis.transportcontrol.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author DPoplauski
 */
@Entity
@Table(name="queues")
public class TransportQueue {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    private long queueId;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderColumn(name="order_id")
    private List<TransportQueueElement> queueElements=new ArrayList<>();
    
    public List getqElements() {
        return queueElements;
    }
    public void setqElements(List qElements) {
        this.queueElements = qElements;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getQueueId() {
        return queueId;
    }
    public void setQueueId(long queueId) {
        this.queueId = queueId;
    }
    public TransportQueue() {
    }

    public TransportQueue(String name, List<TransportQueueElement> qElements) {
        this.name = name;
        this.queueElements = qElements;
    }

    @Override
    public String toString() {
        return "TransportQueue{" + "queueId=" + queueId + ", name=" + name + ", qElements=" + queueElements + '}';
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
        final TransportQueue other = (TransportQueue) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.queueElements, other.queueElements)) {
            return false;
        }
        return true;
    }
    
}
