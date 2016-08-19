/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.avectis.transportcontrol.entity.Driver;
import java.util.List;
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
public class appJUnitTest {
    private static SessionFactory sessionFactory;
    // A SessionFactory is set up once for an application!
    
    public appJUnitTest() {
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
        }
        System.out.println("End");
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
