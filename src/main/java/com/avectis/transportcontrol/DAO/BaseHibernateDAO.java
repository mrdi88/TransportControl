/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avectis.transportcontrol.DAO;
import org.springframework.orm.hibernate5.HibernateTemplate;
/**
 *
 * @author Dima
 */
public abstract class BaseHibernateDAO {
    
    protected HibernateTemplate template;
    
    public HibernateTemplate getTemplate() {
        return template;
    }
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }
}
