/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avectis.transportcontrol.DAO;

import com.avectis.transportcontrol.entity.Card;
import com.avectis.transportcontrol.entity.Queue;
import com.avectis.transportcontrol.entity.QueueElement;
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
public class QueueHibernateDAO implements QueueDAO{
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
     * create new not initialied Queue entity using Hibernate
     * 
     * @return created Queue entity
     */
    @Override
    public Queue createQueue(){
        Queue transportQueue=new Queue();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Long id=(Long)session.save(transportQueue);
            transportQueue.setId(id);
            session.getTransaction().commit();
        }
        return transportQueue;
    }
    /**
     * create new not initialied Queue entity using Hibernate
     * 
     * @param name String - queue name
     * @return created Queue entity
     */
    @Override
    public Queue createQueue(String name){
        Queue transportQueue=new Queue();
        transportQueue.setName(name);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Long id=(Long)session.save(transportQueue);
            transportQueue.setId(id);
            session.getTransaction().commit();
        }
        return transportQueue;
    }
    /**
     * create new Card entity using Hibernate
     * 
     * @return created QueueElement entity
     */
    @Override
    public QueueElement createQueueElement(){
        QueueElement tqElement=new QueueElement();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Long id=(Long)session.save(tqElement);
            tqElement.setId(id);
            session.getTransaction().commit();
        }
        return tqElement;
    }
    /**
     * create new Card entity using Hibernate
     * 
     * @param card Card - card to put into queue
     * @return created QueueElement entity
     */
    @Override
    public QueueElement createQueueElement(Card card){
        QueueElement tqElement=new QueueElement(card);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Long id=(Long)session.save(tqElement);
            tqElement.setId(id);
            session.getTransaction().commit();
        }
        return tqElement;
    }
    /**
     * get QueueElement object from DB using Hibernate
     * 
     * @param id Long - identifier of entity object
     * @return QueueElement object
     */
    @Override
    public QueueElement getQueueElement(Long id){
        QueueElement tqElement;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            tqElement = (QueueElement)session.get(QueueElement.class, id );
            session.getTransaction().commit();
        }
        return tqElement;
    }
    /**
     * get Queue object from DB using Hibernate
     * 
     * @param id Long - identifier of entity object
     * @return Queue object
     */
    @Override
    public Queue getQueue(Long id){
        Queue tq;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            tq = (Queue)session.get(Queue.class, id );
            if (tq!=null) Hibernate.initialize(tq.getqElements());
            session.getTransaction().commit();
        }
        return tq;
    }
    /**
     * get Queue object from DB using Hibernate
     * 
     * @param name String - name of Queue
     * @return Queue object
     */
    @Override
    public Queue getQueueByName(String name){
        Queue tq=null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Queue.class);
            criteria.add( Restrictions.like("name", name));
            List<Queue> l=criteria.list();
            if (l!=null) tq=l.get(0);
            if (tq!=null) Hibernate.initialize(tq.getqElements());
            session.getTransaction().commit();
        }
        return tq;
    }
    /**
     * get all Queue from Queue using Hibernate
     * 
     * @return List of Queue objects
     */
    @Override
    public List<Queue> getQueueList(){
        List<Queue> tqList = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Queue.class);
            tqList=criteria.list();
            for(Queue tq:tqList){
                Hibernate.initialize(tq.getqElements());
            }
            session.getTransaction().commit();
        }
        return tqList;
    }
    /**
     * delete Queue object from DB using Hibernate
     * 
     * @param tq Queue - Queue object to delete
     */
    @Override
    public void deleteQueue(Queue tq){
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
    @Override
    public void deleteQueueElement(QueueElement tqe){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(tqe);
            session.getTransaction().commit();
        }
    }
}
