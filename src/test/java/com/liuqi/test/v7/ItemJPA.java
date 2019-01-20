package com.liuqi.test.v7;

import com.liuqi.entity.v7.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.*;

public class ItemJPA {

    private EntityManagerFactory emf;

    private EntityManager em;

    @Before
    public void setUp(){
        emf = Persistence.createEntityManagerFactory("HelloWorldPU");

        em = emf.createEntityManager();
    }

    @Test
    public void ItemJPAV7_1(){
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
     * 列表持久化
     */
    @Test
    public void ItemJPAV7_2(){
        try {
            EntityTransaction tx = em.getTransaction();

            tx.begin();

            ItemV2 v2 =  new ItemV2();

            v2.setName("Foo");

            List<String> list = new ArrayList<>(6);

            list.add("foo.jpg");

            list.add("bar.jpg");

            list.add("baz.jpg");

            list.add("baz.jpg");

            v2.setImages(list);

            em.persist(v2);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    /**
     * 查询
     */
    @Test
    public void ItemJPAV7_3(){
        try {
            EntityTransaction tx = em.getTransaction();

            tx.begin();

            List<ItemV2>  list = em.createQuery("select i from ItemV2 i").getResultList();

            assertEquals(1,list.size());

            assertEquals(4,list.get(0).getImages().size());

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    /**
     * 脏检查
     */
    @Test
    public void ItemJPAV7_4(){
        try {
            EntityTransaction tx = em.getTransaction();

            tx.begin();

            List<ItemV2>  list = em.createQuery("select i from ItemV2 i").getResultList();

            List<String> images = list.get(0).getImages();

            images.remove(0);

            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    /**
     * Map映射
     */
    @Test
    public void ItemJPAV7_5(){
        try {
            EntityTransaction tx = em.getTransaction();

            tx.begin();

            ItemV3 v3 = new ItemV3();

            v3.setName("Foo");

            Map<String,String> map = new HashMap<>(6);

            map.put("foo.jpg","foo");

            map.put("bar.jpg","bar");

            map.put("baz.jpg","baz");

            map.put("b1.jpg","b1");

            v3.setImages(map);

            em.persist(v3);

            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    /**
     * Map映射
     */
    @Test
    public void ItemJPAV7_6(){
        try {
            EntityTransaction tx = em.getTransaction();

            tx.begin();

            ItemV4 v4 = new ItemV4();

            v4.setName("Foo");

            Map<String,String> map = new HashMap<>(6);

            map.put("foo.jpg","foo");

            map.put("bar.jpg","bar");

            map.put("baz.jpg","baz");

            map.put("b1.jpg","b1");

            map.put("c1.jpg","c1");

            map.put("a1.jpg","a1");

            v4.setMap(map);

            em.persist(v4);

            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    /**
     * map排序、删除
     */
    @Test
    public void ItemJPAV7_7(){
        try {
            EntityTransaction tx = em.getTransaction();

            tx.begin();

            List<ItemV4> itemV4s = em.createQuery("select i from ItemV4 i").getResultList();

            assertEquals(1,itemV4s.size());

            assertEquals(6,itemV4s.get(0).getMap().size());

            Map<String, String> map = itemV4s.get(0).getMap();

            map.remove("c1.jpg");

            for (Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println(entry.getKey()+"====="+entry.getValue());
            }

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    /**
     * 多对一
     */
    @Test
    public void ItemJPAV7_8(){
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
     * 一对多
     */
    @Test
    public void ItemJPAV7_9(){
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
     * 持久化
     */
    @Test
    public void ItemJPAV7_10(){
        try {
            EntityTransaction tx = em.getTransaction();

            tx.begin();

            ItemV5 v5 = new ItemV5();

            v5.setName("Foo");

            Map<String,String> map = new HashMap<>(6);

            map.put("foo.jpg","foo");

            map.put("bar.jpg","bar");

            v5.setMap(map);

            em.persist(v5);

            BidV1 bidV1 =  new BidV1();

            bidV1.setPrice(new BigDecimal("105.50"));

            v5.getBidV1s().add(bidV1);

            em.persist(bidV1);

            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    /**
     * 持久化,级联保存
     */
    @Test
    public void ItemJPAV7_11(){
        try {
            EntityTransaction tx = em.getTransaction();

            tx.begin();

            ItemV5 v5 = new ItemV5();

            v5.setName("Foo");

            Map<String,String> map = new HashMap<>(6);

            map.put("foo.jpg","foo");

            map.put("bar.jpg","bar");

            v5.setMap(map);

            em.persist(v5);

            BidV1 bidV1 =  new BidV1();

            bidV1.setPrice(new BigDecimal("105.50"));

            bidV1.setV5(v5);

            v5.getBidV1s().add(bidV1);

            //脏检查，SQL执行
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    /**
     * 级联删除
     */
    @Test
    public void ItemJPAV7_12(){
        try {
            EntityTransaction tx = em.getTransaction();

            tx.begin();

            ItemV5 item = em.find(ItemV5.class, 3l);

            em.remove(item);

            //脏检查，SQL执行
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
