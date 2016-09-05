/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avectis.transportcontrol.facade;

import com.avectis.transportcontrol.DAO.CardDAO;
import com.avectis.transportcontrol.DAO.QueueDAO;
import com.avectis.transportcontrol.entity.Card;
import com.avectis.transportcontrol.entity.Queue;
import com.avectis.transportcontrol.view.CardView;
import com.avectis.transportcontrol.view.QueueView;
import java.util.ArrayList;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Dima
 */
public class QueueFacade {
    
    private QueueDAO queueDAO;
    private CardDAO cardDAO;
    
    public QueueFacade() {
    }
    
    public void setQueueDAO(QueueDAO queueDAO) {
        this.queueDAO = queueDAO;
    }

    public void setCardDAO(CardDAO cardDAO) {
        this.cardDAO = cardDAO;
    }
    
    @Transactional(readOnly = true)
    public QueueView getQueue(Long id){
        return new QueueView(queueDAO.getQueue(id));
    }
    @Transactional(readOnly = true)
    public List<QueueView> getQueueList(){
        List<QueueView> qvList=new ArrayList<>();
        List<Queue> qList = queueDAO.getQueueList();
        for (Queue q:qList){
            qvList.add(new QueueView(q));
        }
        return qvList;
    }
    @Transactional
    public void update(QueueView queueView){
        queueDAO.update(queueFromView(queueView));
    }
    @Transactional
    public void delete(QueueView qv){
        queueDAO.deleteQueue(queueFromView(qv));
    }
    private Queue queueFromView(QueueView queueView){
        Queue queue=new Queue();
        queue.setId(queueView.getId());
        queue.setName(queueView.getName());
        List<Card> cards=new ArrayList<>();
        for (CardView cv:queueView.getCards()){
            cards.add(cardDAO.getCard(cv.getId()));
        }
        queue.setCards(cards);
        return queue;
    }
}