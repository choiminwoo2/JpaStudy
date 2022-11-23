package jpabook.jpashop;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAMain {
    public static void main(String[] args) {
        //JPA 컨텍스트에 내가 설정한 DB를 추가해줌.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager entityManager = emf.createEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        try {
           tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            entityManager.close();
        }

        emf.close();
    }
}

