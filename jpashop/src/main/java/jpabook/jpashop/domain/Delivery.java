package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Delivery {
    @Id @GeneratedValue
    private Long id;

    private String city;
    private String parent;
    @Enumerated(EnumType.STRING)
    private DeliveryState status;

    @OneToOne(mappedBy = "delivery")
    private Order order;
}
