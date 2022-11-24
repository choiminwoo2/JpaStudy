package jpabook.jpashop.domain;

import com.sun.org.apache.xpath.internal.operations.Or;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class OrderItem {
    @Id @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @Column(name = "ORDER_ID")
    private Order order;

    @Column(name = "ITEM_ID")
    private Long item_id;
    private int orderPrice;
    private int count;

}
