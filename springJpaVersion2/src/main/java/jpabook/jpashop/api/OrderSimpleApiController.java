package jpabook.jpashop.api;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import jpabook.jpashop.repository.order.query.OrderFlatDto;
import jpabook.jpashop.repository.order.query.OrderQueryDto;
import jpabook.jpashop.repository.order.query.OrderQueryRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class OrderSimpleApiController {
    private final OrderRepository orderRepository;

    private final OrderQueryRepository orderQueryRepository;
    @GetMapping("/api/v1/simple-orders")
    public List<Order> orederV1(){
        List<Order> all = orderRepository.findAllByString(new OrderSearch());
        all.forEach((item) -> {
            item.getMember().getName(); // LAZY 강제 초기화
            item.getDelivery().getAddress();

            List<OrderItem> orderItems = item.getOrderItems();
            orderItems.stream().forEach(orderItem -> orderItem.getItem().getName());
        });
        return all;

    }

    @GetMapping("/api/v2/orders")
    public List<OrderDto> ordersV2(){
        List<Order> orders = orderRepository.findAllByString(new OrderSearch());
        List<OrderDto> result = orders.stream()
                .map(order -> new OrderDto(order))
                .collect(Collectors.toList());

        return result;
    }

    @GetMapping("/api/v3/orders")
    public List<OrderDto> orderV3(){
        List<Order> orders = orderRepository.findAllWithItem();
        List<OrderDto> result = orders.stream()
                .map(order -> new OrderDto(order))
                .collect(Collectors.toList());

        return result;
    }

    @GetMapping("/api/v3.1/orders")
    public List<OrderDto> orderV3_page(
            @RequestParam(value = "offset", defaultValue = "0") int offset,
            @RequestParam(value = "limit", defaultValue = "10") int limit
    ){
        List<Order> orders = orderRepository.findAllWithMemberDelivery(offset, limit);
        List<OrderDto> result = orders.stream()
                .map(order -> new OrderDto(order))
                .collect(Collectors.toList());

        return result;
    }

    @GetMapping("/api/v4/orders")
    public List<OrderQueryDto> ordersV4(){
        return orderQueryRepository.findOrderQueryDtos();
    }

    @GetMapping("/api/v5/orders")
    public List<OrderQueryDto> ordersV5(){
        return orderQueryRepository.findAllByDto_optimization();
    }

    @GetMapping("/api/v6/orders")
    public List<OrderFlatDto> ordersV6(){

        List<OrderFlatDto> flat = orderQueryRepository.findAllByDto_flat();
        return flat;
    }
    @Data
    static class OrderDto{
    private Long orderId;
    private String name;
    private LocalDateTime orderDate;
    private Address address;
    private List<OrderItemDto> orderItems;

        public OrderDto(Order order){
            orderId = order.getId();
            name = order.getMember().getName();
            orderDate = order.getOrderDate();
            address = order.getDelivery().getAddress();
            orderItems = order.getOrderItems().stream().map(orderItem -> new OrderItemDto(orderItem)).collect(Collectors.toList());
        }
    }

    @Data
    static class OrderItemDto{
        private String itemName;
        private int orderPrice;
        private int count;
        public OrderItemDto(OrderItem item){
            itemName = item.getItem().getName();
            orderPrice = item.getOrderPrice();
            count = item.getCount();
        }

    }

}
