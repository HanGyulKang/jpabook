package jpabook.jpashop.controller.Form;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MemberListForm {

    private Long id;
    private String name;

    private Address address;

    public List<MemberListForm> createReturnMemberList(List<Member> memberList) {
        List<MemberListForm> memberListFormList = new ArrayList<>();

        for(int i = 0; i < memberList.size(); i++) {
            this.setId(memberList.get(i).getId());
            this.setName(memberList.get(i).getName());
            this.setAddress(memberList.get(i).getAddress());
            memberListFormList.add(i, this);
        }

        return memberListFormList;
    }
}
