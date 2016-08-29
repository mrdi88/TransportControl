/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avectis.transportcontrol.DAO;

import com.avectis.transportcontrol.entity.Car;
import com.avectis.transportcontrol.entity.Card;
import com.avectis.transportcontrol.entity.Cargo;
import com.avectis.transportcontrol.entity.Driver;
import com.avectis.transportcontrol.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author DPoplauski
 */
public class CardDAO {
    /**
     * unpade entity using Hibernate
     * 
     * @param object Object - witch entity to update
     */
    public static void Update(Object object){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(object);
	session.getTransaction().commit();
	session.close();
    }
    /**
     * create new not initialied Card entity using Hibernate
     * 
     * @return created Card entity
     */
    public static Card createCard(){
        Card card=new Card();
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Long id=(Long)session.save(card);
        card.setCardId(id);
	session.getTransaction().commit();
	session.close();
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
    public static Card createDriver(Car car, long cardNumber, int accessLevel, int state){
        Card card=new Card(car, cardNumber, state, accessLevel);
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Long id=(Long)session.save(card);
        card.setCardId(id);
	session.getTransaction().commit();
	session.close();
        return card;
    }
    /**
     * get Card object from DB using Hibernate
     * 
     * @return Car object
     */
    public static Card getCard(Long id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Card card=(Card)session.get( Card.class, id );
	session.getTransaction().commit();
	session.close();
        return card;
    }
    /**
     * get all Cards from DB using Hibernate
     * 
     * @return List of Card objects
     */
    public static List<Card> getCards(){
        List<Card> cards = new ArrayList<>();
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Card.class);
        cards=criteria.list();
	session.getTransaction().commit();
	session.close();
        return cards;
    }
    /**
     * delete Card object from DB using Hibernate
     * 
     * @param card Card - card object to delete
     */
    public static void deleteCard(Card card){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(card);
	session.getTransaction().commit();
	session.close();
    }
}
