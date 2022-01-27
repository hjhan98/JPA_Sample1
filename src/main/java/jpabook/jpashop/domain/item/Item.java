package jpabook.jpashop.domain.item;

import jpabook.jpashop.domain.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)   //한 테이블에 다 때려박는 전략 선택
@DiscriminatorColumn(name="dtype")
@Getter @Setter
public abstract class Item {
//추상체로 만듦 : 구현체 따로 만들꺼니까
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="item_id")
    private Integer id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();
}
