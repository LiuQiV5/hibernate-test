package com.liuqi.test.v8;

import com.liuqi.entity.v8.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Set;

public class UserJPA {

    private EntityManagerFactory emf;

    private EntityManager em;

    @Before
    public void setUp(){
        emf = Persistence.createEntityManagerFactory("HelloWorldPU");

        em = emf.createEntityManager();
    }


    /**
     * 建表
     */
    @Test
    public void UserJPAV8_0(){
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

    /**
     * 双向多对多持久化
     */
    @Test
    public void UserJPAV8_3(){
        try {
            EntityTransaction tx = em.getTransaction();

            tx.begin();

            CategoryV1 someCategory = new CategoryV1("some category");

            CategoryV1 otherCategory = new CategoryV1("other category");

            ItemV2 someItem = new ItemV2("some item");

            ItemV2 otherItem = new ItemV2("other item");

            someCategory.getItems().add(someItem);

            someItem.getCategoryV1s().add(someCategory);

            someCategory.getItems().add(otherItem);

            otherItem.getCategoryV1s().add(someCategory);

            otherCategory.getItems().add(someItem);

            someItem.getCategoryV1s().add(otherCategory);

            em.persist(someCategory);

            em.persist(otherCategory);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    /**
     * 具有中间实体的多对多关联
     */
    @Test
    public void UserJPAV8_4(){
        try {
            EntityTransaction tx = em.getTransaction();

            tx.begin();

            CategoryV2 someCategoryv2 = new CategoryV2("some categoryv2");
            CategoryV2 otherCategoryv2 = new CategoryV2("other categoryv2");
            em.persist(someCategoryv2);
            em.persist(otherCategoryv2);

            ItemV3 someItemv3 = new ItemV3("some itemv3");
            ItemV3 otherItemv3 = new ItemV3("other itemv3");
            em.persist(someItemv3);
            em.persist(otherItemv3);

            CategorizedItem linkone = new CategorizedItem("johndoe", someCategoryv2, otherItemv3);

            CategorizedItem linktwo = new CategorizedItem("johndoe", someCategoryv2, someItemv3);

            CategorizedItem linkthree = new CategorizedItem("johndoe", otherCategoryv2, someItemv3);

            em.persist(linkone);
            em.persist(linktwo);
            em.persist(linkthree);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    /**
     * 多对多查询
     */
    @Test
    public void UserJPAV8_5(){
        try {
            EntityTransaction tx = em.getTransaction();

            tx.begin();

            List<CategoryV2> list = em.createQuery("select c from CategoryV2 c").getResultList();

            assertEquals(2,list.size());

            for (CategoryV2 v2 : list) {
                Set<CategorizedItem> categorizedItem = v2.getCategorizedItems();

                System.out.println(v2.getName()+":");

                for (CategorizedItem ct: categorizedItem) {
                    System.out.println("item:"+ct.getItemV3().getName());
                }
            }

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
