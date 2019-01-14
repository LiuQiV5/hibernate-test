package com.liuqi.test.v5;

import com.liuqi.entity.v5.AddressV1;
import com.liuqi.entity.v5.AddressV2;
import com.liuqi.entity.v5.UserV1;
import com.liuqi.entity.v5.UserV2;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserJPA {

    private EntityManagerFactory emf;

    private EntityManager em;

    @Before
    public void setUp(){
        emf = Persistence.createEntityManagerFactory("HelloWorldPU");

        em = emf.createEntityManager();
    }

    @Test
    public void userJPAV5_1(){
        try {
            EntityTransaction tx = em.getTransaction();

            tx.begin();

            UserV1 user =  new UserV1();

            AddressV1 billingAddress = new AddressV1("夏港","20144","江阴");

            user.setBillingAddress(billingAddress);

            em.persist(user);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Test
    public void userJPAV5_2(){
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
