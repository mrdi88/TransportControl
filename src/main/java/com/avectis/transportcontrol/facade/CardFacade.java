/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avectis.transportcontrol.facade;

import com.avectis.transportcontrol.DAO.CardDAO;
import com.avectis.transportcontrol.DAO.QueueDAO;
import com.avectis.transportcontrol.entity.Car;
import com.avectis.transportcontrol.entity.Card;
import com.avectis.transportcontrol.view.CardView;

/**
 *
 * @author Dima
 */
public class CardFacade {
    private CarDAO carDAO;
    private CardDAO cardDAO;
    private QueueDAO queueDAO;

    public CardFacade() {
    }

    public Long add(CardView card){
        return cardDAO.addCard(cardFromView(card));
    }
    
    public void setCardDAO(CardDAO cardDAO) {
        this.cardDAO = cardDAO;
    }

    public void setQueueDAO(QueueDAO queueDAO) {
        this.queueDAO = queueDAO;
    }
    private Card cardFromView(CardView cardv){
        Card card = new Card();
        Car car=null;
        if (cardv.getCar()!= null && cardv.getCar().getId()!=null && cardv.getCar().getId() > 0) {
            car = carDAO.getCar(cardv.getCar().getId());
        }
        card.setCar(car);
        card.setAccessLevel(cardv.getAccessLevel());
        card.setCardNumber(cardv.getCardNumber());
        card.setCreateDate(cardv.getCreateDate());
        card.setId(cardv.getId());
        card.setState(cardv.getState());
        return card;
    }
}
