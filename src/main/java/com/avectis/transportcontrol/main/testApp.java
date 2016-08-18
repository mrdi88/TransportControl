/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avectis.transportcontrol.main;
import com.avectis.transportcontrol.entity.*;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
/**
 *
 * @author DPoplauski
 */
public class testApp {
    private static SessionFactory sessionFactory;
    
    public static void main(String args[]) {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                        .configure() // configures settings from hibernate.cfg.xml
                        .build();
        try {
                sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
                // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
                // so destroy it manually.
                System.out.println("ex: " + e);
                StandardServiceRegistryBuilder.destroy( registry );
        }
        try {
            // create a couple of drivers...
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save( new Driver( "Dima", "+375292051312","avectis") );
		session.getTransaction().commit();
		session.close();

		// now lets pull events from the database and list them
		session = sessionFactory.openSession();
		session.beginTransaction();
		List result = session.createQuery( "from Driver" ).list();
		for ( Driver driver : (List<Driver>) result ) {
			System.out.println( "driver (" + driver.getName()+ ") : " + driver.getMobileNumber());
		}
		session.getTransaction().commit();
		session.close();
        }
        catch(Exception e) {
            System.out.println("ex: " + e);
        }
        System.out.println("End");
    }
    
}
