package com.liuqi.test.v5;

import com.liuqi.entity.v5.ItemV5;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class ItemJPA {

    private EntityManagerFactory emf;

    private EntityManager em;

    @Before
    public void setUp(){
        emf = Persistence.createEntityManagerFactory("HelloWorldPU");

        em = emf.createEntityManager();
    }

    @Test
    public void ItemJPAV5_1(){
        try {
            EntityTransaction tx = em.getTransaction();

            tx.begin();

            ItemV5 it = new ItemV5();

            it.setWeight_kg(2);

            em.persist(it);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    /**
     * 使用SQL表达式转换列值
     */
    @Test
    public void queryItem(){
        List<ItemV5> resultList = em.createQuery("select i from ItemV5 i where i.weight_kg = :w")
                                        .setParameter("w", 2.35)
                                        .getResultList();

        assertEquals(1,resultList.size());

        System.out.println(resultList.get(0).getWeight_kg());
    }

    @Test
    public void ItemJPAV5_6(){
        try {
            EntityTransaction tx = em.getTransaction();

            tx.begin();
            
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
