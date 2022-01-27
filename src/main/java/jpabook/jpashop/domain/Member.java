package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name="tb_member")
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="member_id")
    private Integer id;

    @Column(name = "username")
    private String name;

    @Embedded           //내장타입
    private Address address;

    @OneToMany(mappedBy ="member")      // 1:多 = 회원:주문 //연관관계의 거울(맵핑된애)(ReadOnly) "order"필드에 의해서 맵핑이된거임
    private List<Order> orders = new ArrayList<>();
}
