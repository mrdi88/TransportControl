/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avectis.transportcontrol.DAO;

import com.avectis.transportcontrol.entity.Card;
import com.avectis.transportcontrol.entity.TransportQueue;
import com.avectis.transportcontrol.entity.TransportQueueElement;
import com.avectis.transportcontrol.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author DPoplauski
 */
public class TransportQueueDAO {
    /**
     * unpade entity using Hibernate
     * 
     * @param object Object - witch entity to update
     */
    public static void Update(Object object){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();
        }
    }
    /**
     * create new not initialied TransportQueue entity using Hibernate
     * 
     * @return created TransportQueue entity
     */
    public static TransportQueue createQueue(){
        TransportQueue transportQueue=new TransportQueue();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Long id=(Long)session.save(transportQueue);
            transportQueue.setQueueId(id);
            session.getTransaction().commit();
        }
        return transportQueue;
    }
    /**
     * create new not initialied TransportQueue entity using Hibernate
     * 
     * @param name String - queue name
     * @return created TransportQueue entity
     */
    public static TransportQueue createQueue(String name){
        TransportQueue transportQueue=new TransportQueue();
        transportQueue.setName(name);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Long id=(Long)session.save(transportQueue);
            transportQueue.setQueueId(id);
            session.getTransaction().commit();
        }
        return transportQueue;
    }
    /**
     * create new Card entity using Hibernate
     * 
     * @return created TransportQueueElement entity
     */
    public static TransportQueueElement createQueueElement(){
        TransportQueueElement tqElement=new TransportQueueElement();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Long id=(Long)session.save(tqElement);
            tqElement.setqElementId(id);
            session.getTransaction().commit();
        }
        return tqElement;
    }
    /**
     * create new Card entity using Hibernate
     * 
     * @param card Card - card to put into queue
     * @return created TransportQueueElement entity
     */
    public static TransportQueueElement createQueueElement(Card card){
        TransportQueueElement tqElement=new TransportQueueElement(card);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Long id=(Long)session.save(tqElement);
            tqElement.setqElementId(id);
            session.getTransaction().commit();
        }
        return tqElement;
    }
    /**
     * get TransportQueueElement object from DB using Hibernate
     * 
     * @param id Long - identifier of entity object
     * @return TransportQueueElement object
     */
    public static TransportQueueElement getQueueElement(Long id){
        TransportQueueElement tqElement;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            tqElement = (TransportQueueElement)session.get( TransportQueueElement.class, id );
            session.getTransaction().commit();
        }
        return tqElement;
    }
    /**
     * get TransportQueue object from DB using Hibernate
     * 
     * @param id Long - identifier of entity object
     * @return TransportQueue object
     */
    public static TransportQueue getQueue(Long id){
        TransportQueue tq;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            tq = (TransportQueue)session.get( TransportQueue.class, id );
            if (tq!=null) Hibernate.initialize(tq.getqElements());
            session.getTransaction().commit();
        }
        return tq;
    }
    /**
     * get TransportQueue object from DB using Hibernate
     * 
     * @param name String - name of TransportQueue
     * @return TransportQueue object
     */
    public static TransportQueue getQueueByName(String name){
        TransportQueue tq=null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(TransportQueue.class);
            criteria.add( Restrictions.like("name", name));
            List<TransportQueue> l=criteria.list();
            if (l!=null) tq=l.get(0);
            if (tq!=null) Hibernate.initialize(tq.getqElements());
            session.getTransaction().commit();
        }
        return tq;
    }
    /**
     * get all TransportQueue from Queue using Hibernate
     * 
     * @return List of TransportQueue objects
     */
    public static List<TransportQueue> getQueueList(){
        List<TransportQueue> tqList = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(TransportQueue.class);
            tqList=criteria.list();
            for(TransportQueue tq:tqList){
                Hibernate.initialize(tq.getqElements());
            }
            session.getTransaction().commit();
        }
        return tqList;
    }
    /**
     * delete TransportQueue object from DB using Hibernate
     * 
     * @param tq TransportQueue - TransportQueue object to delete
     */
    public static void deleteQueue(TransportQueue tq){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(tq);
            session.getTransaction().commit();
        }
    }
    /**
     * delete deleteQueueElement object from DB using Hibernate
     * 
     * @param tqe deleteQueueElement - deleteQueueElement object to delete
     */
    public static void deleteQueueElement(TransportQueueElement tqe){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(tqe);
            session.getTransaction().commit();
        }
    }
}
