/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avectis.transportcontrol.DAO;

import com.avectis.transportcontrol.entity.Card;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

/**
 *
 * @author DPoplauski
 */
public class CardHibernateDAO extends BaseHibernateDAO implements CardDAO{
     /**
     * add new Card entity using Hibernate
     * 
     * @param card Card 
     * @return created Card entity
     */
    @Override
    public Long addCard(Card card){
            return (Long)template.save(card);
    }
     /**
     * unpade Card using Hibernate
     * 
     * @param card Card - witch entity to update
     */
    @Override
    public void Update(Card card){
            template.update(card);
    }
    /**
     * get Car object from DB using Hibernate
     * 
     * @param id
     * @return Card object
     */
    @Override
    public Card getCard(Long id){
        return (Card) template.load(Card.class, id);
    }
    /**
     * get all Cards from DB using Hibernate
     * 
     * @return List of Card objects
     */
    @Override
    public List<Card> getCards(){
        DetachedCriteria criteria = DetachedCriteria.forClass(Card.class);
        criteria.addOrder(Order.desc("createDate"));
        return (List<Card>)template.findByCriteria(criteria);
    }
    /**
     * delete Card object from DB using Hibernate
     * 
     * @param card Card - card object to delete
     */
    @Override
    public void deleteCard(Card card){
        template.delete(card);
    }
}
