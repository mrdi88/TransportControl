/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avectis.transportcontrol.DAO;
/**
 *
 * @author Dima
 */
public class DAO {
    public static final CarDAO carDAO=new CarHibernateDAO();
    public static final CardDAO cardDAO=new CardHibernateDAO();
    public static final QueueDAO queueDAO=new QueueHibernateDAO();
}
