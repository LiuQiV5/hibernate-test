package com.liuqi.test.v4;

import com.liuqi.entity.v2.Message;
import com.liuqi.entity.v4.Item;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ItemJPA {

    private EntityManagerFactory emf;

    private EntityManager em;

    @Before
    public void setUp(){
         emf = Persistence.createEntityManagerFactory("HelloWorldPU");

        em = emf.createEntityManager();
    }

    @Test
    public void ItemJPAV4_1(){
        try {
            EntityTransaction tx = em.getTransaction();

            tx.begin();

            Item it = new Item();

            em.persist(it);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
