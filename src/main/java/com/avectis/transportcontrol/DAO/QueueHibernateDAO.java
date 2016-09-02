/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avectis.transportcontrol.DAO;

import com.avectis.transportcontrol.entity.Queue;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author DPoplauski
 */
public class QueueHibernateDAO extends BaseHibernateDAO implements QueueDAO{
    /**
     * unpade entity using Hibernate
     * 
     * @param queue Queue - witch entity to update
     */
    @Override
    public void Update(Queue queue){
            template.update(queue);
    }
    /**
     * add new Queue entity using Hibernate
     * 
     * @return created Queue entity
     */
    @Override
    public Long addQueue(Queue queue){
        return (Long)template.save(queue);
    }
    /**
     * get Queue object from DB using Hibernate
     * 
     * @param id Long - identifier of entity object
     * @return Queue object
     */
    @Override
    public Queue getQueue(Long id){
        return (Queue)template.load(Queue.class, id );
    }
    /**
     * get Queue object from DB using Hibernate
     * 
     * @param name String - name of Queue
     * @return Queue object
     */
    @Override
    public List<Queue> getQueueByName(String name){
        DetachedCriteria criteria = DetachedCriteria.forClass(Queue.class);
        criteria.addOrder(Order.desc("createDate"));
        criteria.add(Restrictions.eq("name", name));
        return (List<Queue>)template.findByCriteria(criteria);    
    }
    /**
     * get all Queue from Queue using Hibernate
     * 
     * @return List of Queue objects
     */
    @Override
    public List<Queue> getQueueList(){
        DetachedCriteria criteria = DetachedCriteria.forClass(Queue.class);
        return (List<Queue>)template.findByCriteria(criteria);    
    }
    /**
     * delete Queue object from DB using Hibernate
     * 
     * @param queue Queue - Queue object to delete
     */
    @Override
    public void deleteQueue(Queue queue){
        template.delete(queue);
    }
}
