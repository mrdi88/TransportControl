/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avectis.transportcontrol.DAO;

import com.avectis.transportcontrol.entity.Car;
import com.avectis.transportcontrol.entity.Card;
import com.avectis.transportcontrol.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author DPoplauski
 */
public class CardHibernateDAO implements CardDAO{
    /**
     * unpade entity using Hibernate
     * 
     * @param object Object - witch entity to update
     */
    @Override
    public void Update(Object object){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();
        }
    }
    /**
     * create new not initialied Card entity using Hibernate
     * 
     * @return created Card entity
     */
    @Override
    public Card createCard(){
        Card card=new Card();
        Date dt=new Date();
        dt.setTime(dt.getTime()-dt.getTime()%1000);
        card.setCreateDate(dt);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Long id=(Long)session.save(card);
            card.setId(id);
            session.getTransaction().commit();
        }
        return card;
    }
    /**
     * create new Card entity using Hibernate
     * 
     * @param car Car - car assotiated with card 
     * @param cardNumber long - card identifier
     * @param accessLevel int - driver's organization
     * @param state int - aditional parameter
     * @return created Card entity
     */
    @Override
    public Card createCard(Car car, long cardNumber, int accessLevel, int state){
        Card card=new Card(car, cardNumber, state, accessLevel);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Long id=(Long)session.save(card);
            card.setId(id);
            session.getTransaction().commit();
        }
        return card;
    }
    /**
     * get Card object from DB using Hibernate
     * 
     * @param id Long - identifier of entity object
     * @return Car object
     */
    @Override
    public Card getCard(Long id){
        Card card;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            card = (Card)session.get( Card.class, id );
            session.getTransaction().commit();
        }
        return card;
    }
    /**
     * get all Cards from DB using Hibernate
     * 
     * @return List of Card objects
     */
    @Override
    public List<Card> getCards(){
        List<Card> cards = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Card.class);
            cards=criteria.list();
            session.getTransaction().commit();
        }
        return cards;
    }
    /**
     * delete Card object from DB using Hibernate
     * 
     * @param card Card - card object to delete
     */
    @Override
    public void deleteCard(Card card){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(card);
            session.getTransaction().commit();
        }
    }
}
