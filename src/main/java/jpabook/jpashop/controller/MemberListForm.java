package jpabook.jpashop.controller;

import jpabook.jpashop.domain.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Embedded;

@Getter
@Setter
public class MemberListForm {

    private Long id;
    private String name;

    private Address address;
}
