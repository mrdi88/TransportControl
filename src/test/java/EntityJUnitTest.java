/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.avectis.transportcontrol.entity.Cargo;
import com.avectis.transportcontrol.entity.Driver;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author DPoplauski
 */
public class EntityJUnitTest {
    private static SessionFactory sessionFactory;
    // A SessionFactory is set up once for an application!
    
    public EntityJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("tests begins");
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
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("tests ends");
        if ( sessionFactory != null ) {
			sessionFactory.close();
	}
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void testDriver(){
        try {
                // create a couple of drivers...
                System.out.println("driver test began");
		Session session = sessionFactory.openSession();
		session.beginTransaction();
                Driver dr1=new Driver( "Dima", "+375292051312","avectis");
                Long id=(Long)session.save(dr1);
		session.getTransaction().commit();
		session.close();
                System.out.println("saved in db: "+dr1);
                // get driver
                session = sessionFactory.openSession();
		session.beginTransaction();
		Driver dr2=(Driver)session.get( Driver.class, id );
		session.getTransaction().commit();
		session.close();
		System.out.println("red from db :"+dr2);
                // is equal
                assertEquals(dr1, dr2);
                // delete object
                session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(dr2);
		session.getTransaction().commit();
		session.close();
                System.out.println("object deleted");
                //check that it not exists
                session = sessionFactory.openSession();
		session.beginTransaction();
		dr1=(Driver)session.get(Driver.class,id);
		session.getTransaction().commit();
		session.close();
                assertEquals(dr1, null);
        }
        catch(Exception e) {
            System.out.println("ex: " + e);
            fail();
        }
        System.out.println("End");
    }
    @Test
    public void testCargo(){
        try {
                // create a couple of drivers...
                System.out.println("cargo test began");
		Session session = sessionFactory.openSession();
		session.beginTransaction();
                Cargo cargo1=new Cargo();
                cargo1.setWeightIn(5000);
                cargo1.setQuality(5);
                Date dt= new Date();
                cargo1.setLoadingDate(dt);
                Long id=(Long)session.save(cargo1);
		session.getTransaction().commit();
		session.close();
                System.out.println("saved in db: "+cargo1);
                // get cargo
                session = sessionFactory.openSession();
		session.beginTransaction();
		Cargo cargo2=(Cargo)session.get( Cargo.class, id );
		session.getTransaction().commit();
		session.close();
		System.out.println("red from db :"+cargo2);
                // is equal
                assertEquals(cargo1, cargo2);
                // delete object
                session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(cargo2);
		session.getTransaction().commit();
		session.close();
                System.out.println("object deleted");
                //check that it not exists
                session = sessionFactory.openSession();
		session.beginTransaction();
		cargo2=(Cargo)session.get(Cargo.class,id);
		session.getTransaction().commit();
		session.close();
                assertEquals(cargo2, null);
        }
        catch(Exception e) {
            System.out.println("ex: " + e);
            fail();
        }
        System.out.println("End");
    }
}
