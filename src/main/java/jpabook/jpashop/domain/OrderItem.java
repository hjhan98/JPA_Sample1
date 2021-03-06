package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="item_id")
    private Item item;

    @ManyToOne  //多:1 = orderItem : order
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice; //주문 가격
    private int count;      //주문 수량


}
