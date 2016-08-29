/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avectis.transportcontrol.DAO;

import com.avectis.transportcontrol.entity.Card;
import com.avectis.transportcontrol.entity.Queue;
import com.avectis.transportcontrol.entity.QueueElement;
import java.util.List;

/**
 *
 * @author DPoplauski
 */
public interface QueueDAO {
    
    public void Update(Object object);
    public Queue createQueue();
    public Queue createQueue(String name);
    public QueueElement createQueueElement();
    public QueueElement createQueueElement(Card card);
    public QueueElement getQueueElement(Long id);
    public Queue getQueue(Long id);
    public Queue getQueueByName(String name);
    public List<Queue> getQueueList();
    public void deleteQueue(Queue tq);
    public void deleteQueueElement(QueueElement tqe);
}
