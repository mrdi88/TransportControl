/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avectis.transportcontrol.entity;

import java.util.List;

/**
 *
 * @author DPoplauski
 */
public class TransportQueue {

    private long queueId;
    private String name;
    private List<TransportQueueElement> qElements;
    
    public List getqElements() {
        return qElements;
    }
    public void setqElements(List qElements) {
        this.qElements = qElements;
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
}
