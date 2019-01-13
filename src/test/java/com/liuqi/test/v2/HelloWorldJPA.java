package com.liuqi.test.v2;


import com.liuqi.entity.v2.Message;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class HelloWorldJPA {

   private EntityManagerFactory emf;

   private EntityManager em;

    @Before
    public void setUp(){
        emf = Persistence.createEntityManagerFactory("HelloWorldPU");

        em = emf.createEntityManager();
   }

   @Test
    public void HelloWorldTestV1(){
        try {
            EntityTransaction tx = em.getTransaction();

            tx.begin();

            Message message = new Message();

            message.setText("Hello World!");

            em.persist(message);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
   }

   @Test
    public void HelloWorldTestV2(){
        try {
            EntityTransaction tx = em.getTransaction();

            tx.begin();

            List<Message> messages = em.createQuery("select m from Message m").getResultList();

            assertEquals(messages.size(),1);

            assertEquals(messages.get(0).getText(),"Hello World!");

            messages.get(0).setText("Take me to your leader!");

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
   }
}
