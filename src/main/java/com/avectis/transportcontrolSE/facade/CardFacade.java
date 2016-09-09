/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avectis.transportcontrolSE.facade;

import com.avectis.transportcontrolSE.DAO.CarDAO;
import com.avectis.transportcontrolSE.DAO.CardDAO;
import com.avectis.transportcontrolSE.DAO.QueueDAO;
import com.avectis.transportcontrolSE.entity.Car;
import com.avectis.transportcontrolSE.entity.Card;
import com.avectis.transportcontrolSE.view.CardView;
import java.util.ArrayList;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Dima
 */
public class CardFacade {
    private CarDAO carDAO;
    private CardDAO cardDAO;
    private QueueDAO queueDAO;
    private CarFacade carFacade;

    public CardFacade() {
    }
    @Transactional
    public Long add(CardView card){
        return cardDAO.addCard(cardFromView(card));
    }
    @Transactional
    public void update(CardView card){
        cardDAO.Update(cardFromView(card));
    }
    @Transactional(readOnly = true)
    public CardView getCard(Long id){
        return new CardView(cardDAO.getCard(id));
    }
    @Transactional(readOnly = true)
    public List<CardView> getList(){
        List<Card> cards=cardDAO.getCards();
        List<CardView> cardsView= new ArrayList<>();
        for (Card card:cards){
            cardsView.add(new CardView(card));
        }
        return cardsView;
    }
    @Transactional
    public void delete(CardView card){
        cardDAO.deleteCard(cardFromView(card));
    }
    public void setCardDAO(CardDAO cardDAO) {
        this.cardDAO = cardDAO;
    }
    public void setCarDAO(CarDAO carDAO) {
        this.carDAO = carDAO;
    }
    public void setQueueDAO(QueueDAO queueDAO) {
        this.queueDAO = queueDAO;
    }

    public void setCarFacade(CarFacade carFacade) {
        this.carFacade = carFacade;
    }
    public Card cardFromView(CardView cardv){
        Card card;
        if (cardv.getId() != null && cardv.getId() > 0) {
            card = cardDAO.getCard(cardv.getId());
        } else {
            card = new Card();
        }
        Car car = null;
        if (cardv.getCar()!= null ){
            car=carFacade.carFromView(cardv.getCar());
        }
        card.setCar(car);
        card.setAccessLevel(cardv.getAccessLevel());
        card.setCardNumber(cardv.getCardNumber());
        card.setCreateDate(cardv.getCreateDate());
        card.setState(cardv.getState());
        return card;
    }
}
