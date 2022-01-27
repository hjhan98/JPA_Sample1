package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Embeddable     //어딘가에 내장될 수 있다!
@Getter         // 실무에서는 Getter는 열고 Setter는 안쓰는거 추천!
public class Address {

    private String city;
    private String street;
    private String zipcode;
}
