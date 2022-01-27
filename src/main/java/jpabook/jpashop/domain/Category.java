package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Category {
    @Id @GeneratedValue
    @Column(name = "category_id")
    private int Id;

    private String name;

    @ManyToMany
    // 관계형 디비는 컬렉션 관계를 양쪽에서 가질 수 없기 때문에 다:다 관계는 1:다 다:1로 풀어내는 중간 테이블 필요 (실무에서는 잘 안씀)
    @JoinTable(name = "category_item",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

}


//shift + ctrl + alt + L : 줄 정렬