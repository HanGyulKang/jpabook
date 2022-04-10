package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable // 내장타입
@Getter
public class Address {

    // 값 타입은 변경 불가능하게 설계해야한다.
    private String city;
    private String street;
    private String zipcode;

    // 함부로 new로 생성하면 안 되기 때문에 protected로 묶어놓는다.
    // JPA 스펙에 나와있는 제약.
    protected Address() {}

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
