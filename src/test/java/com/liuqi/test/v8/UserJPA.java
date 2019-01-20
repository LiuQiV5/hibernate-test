package com.liuqi.test.v8;

import com.liuqi.entity.v8.AddressV1;
import com.liuqi.entity.v8.AddressV2;
import com.liuqi.entity.v8.UserV1;
import com.liuqi.entity.v8.UserV2;
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

    /**
     * 持久化user,address
     */
    @Test
    public void UserJPAV8_1(){
        try {
            EntityTransaction tx = em.getTransaction();

            tx.begin();

            AddressV1 someCity = new AddressV1("some street 123", "12345", "some city");

            em.persist(someCity);


            UserV1 userV1 = new UserV1(someCity.getId(), "johndoe");

            userV1.setShippingAddress(someCity);

            em.persist(userV1);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    /**
     * 双向一对一持久化user,address
     */
    @Test
    public void UserJPAV8_2(){
        try {
            EntityTransaction tx = em.getTransaction();

            tx.begin();

            UserV2 userV2 = new UserV2("johndoe");

            AddressV2 addressV2 = new AddressV2(userV2, "some street 456", "45678", "jiangyin");

            userV2.setShippingAddress(addressV2);

            em.persist(userV2);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
