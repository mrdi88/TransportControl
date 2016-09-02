/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avectis.transportcontrol.facade;

import com.avectis.transportcontrol.DAO.QueueDAO;

/**
 *
 * @author Dima
 */
public class QueueFacade {

    private QueueDAO queueDAO;

    public QueueFacade() {
    }

    public void setQueueDAO(QueueDAO queueDAO) {
        this.queueDAO = queueDAO;
    }
    
}
