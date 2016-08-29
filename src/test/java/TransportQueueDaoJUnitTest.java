/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.avectis.transportcontrol.DAO.DAO;
import com.avectis.transportcontrol.DAO.QueueHibernateDAO;
import com.avectis.transportcontrol.entity.Queue;
import com.avectis.transportcontrol.entity.QueueElement;
import java.util.List;
import java.util.TimeZone;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author DPoplauski
 */
public class TransportQueueDaoJUnitTest {
    
    public TransportQueueDaoJUnitTest() {
    }
    @BeforeClass
    public static void setUpClass() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        System.out.println("TransportQueueDao test begins");
    }
    @AfterClass
    public static void tearDownClass() {
        System.out.println("TransportQueueDao test ends");
    }
    
    @Test
    public void transportQueue() {
        try{
            //===Queue
            Queue tq1=DAO.queueDAO.createQueue("R01");
            Queue tq2=DAO.queueDAO.createQueue("R02");
            Queue tq3=DAO.queueDAO.createQueue("R03");
            Queue tq4=DAO.queueDAO.createQueue("R04");
            //===Elements
            QueueElement elem1=DAO.queueDAO.createQueueElement();
            QueueElement elem2=DAO.queueDAO.createQueueElement();
            QueueElement elem3=DAO.queueDAO.createQueueElement();
            //===
            tq1.getqElements().add(elem1);
            tq1.getqElements().add(elem2);
            tq1.getqElements().add(elem3);
            DAO.queueDAO.Update(tq1);
            //===
            QueueElement elem4=new QueueElement();
            tq2.getqElements().add(elem4);
            tq2.getqElements().add(new QueueElement());
            DAO.queueDAO.Update(tq2);
            //=get
            List<Queue> list=DAO.queueDAO.getQueueList();
            for(Queue tq:list){
                System.out.println("queue name: " + tq.getName());
            }
            System.out.println("list size: " + list.size());
            System.out.println("TransportQueue list: " + list);
            //asserts
            System.out.println("tq1: " + tq1);
            System.out.println("tD1: " + DAO.queueDAO.getQueue(tq1.getId()));
            assertEquals(tq1, DAO.queueDAO.getQueue(tq1.getId()));
            assertEquals(tq2, DAO.queueDAO.getQueue(tq2.getId()));
            assertEquals(tq3, DAO.queueDAO.getQueue(tq3.getId()));
            assertEquals(tq4, DAO.queueDAO.getQueue(tq4.getId()));
            //delete
            DAO.queueDAO.deleteQueue(tq1);
            DAO.queueDAO.deleteQueue(tq2);
            DAO.queueDAO.deleteQueue(tq3);
            DAO.queueDAO.deleteQueue(tq4);
            //asserts
            assertEquals(null, DAO.queueDAO.getQueue(tq1.getId()));
            assertEquals(null, DAO.queueDAO.getQueue(tq2.getId()));
            assertEquals(null, DAO.queueDAO.getQueue(tq3.getId()));
            assertEquals(null, DAO.queueDAO.getQueue(tq4.getId()));
        }
        catch(Exception e){
            System.out.println("TransportQueue ex: " + e);
            e.printStackTrace();
            fail();
        }
    }    
}
