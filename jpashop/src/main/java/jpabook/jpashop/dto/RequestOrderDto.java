package jpabook.jpashop.dto;


import jpabook.jpashop.domain.OrderItem;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RequestOrderDto {

    // 주문일, 주문상품명, 주문번호, 맴버 아이디
    private String order_Id;
    private String member_id;
    private LocalDateTime orderDate;
    private List<OrderItem> useOrderItems;
    @Builder
    public RequestOrderDto(String order_Id, String member_id, LocalDateTime orderDate, List<OrderItem> useOrderItems){
        this.order_Id = order_Id;
        this.member_id = member_id;
        this.orderDate = orderDate;
        useOrderItems = useOrderItems;

    }
}
