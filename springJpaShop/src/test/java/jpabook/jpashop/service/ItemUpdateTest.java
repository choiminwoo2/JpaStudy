package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemUpdateTest {

    @Autowired
    EntityManager entityManager;

    @Test
    public void updateTest() throws  Exception {
        Book book = entityManager.find(Book.class, 1L);

        //TX
        book.setName("asdFasdf");

        //변경감지 = dirty chk 준영속 엔티티

    }
}
