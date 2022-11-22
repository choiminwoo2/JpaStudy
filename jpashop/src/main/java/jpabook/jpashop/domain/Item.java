package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Item {
    @Id @GeneratedValue
    @Column("ITEM_ID")
    private Long id;
    private String name;
    private int price;
    private  int stockQuantity;

}
