package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private Integer id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded       //내장타임을 포함했다!
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;  //Ready, Comp

    //* Enum Type 중 Ordinary 안쓰는 이유: 1,2,..이렇게 기본 이넘값으로 사용되는 편리함은 있지만
    //  중간에 뭐 하나 끼면 숫자 밀려서 장애 발생 가능성 높음음
}
