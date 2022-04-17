package jpabook.jpashop.controller;

import jpabook.jpashop.controller.Form.MemberForm;
import jpabook.jpashop.controller.Form.MemberListForm;
import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 등록 폼 화면을 열어보는 목적 : Get
    @GetMapping("/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
    }

    // 멤버 정보를 등록하려는 목적 : Post
    @PostMapping("members/new")
    public String create(@Valid MemberForm form, BindingResult result) {
        /**
         * [Member Entity가 있는데 MemberForm 클래스를 굳이 생성한 이유]
         * Member Entity를 사용하면 거기에 Validation 체크도 넣어야 하고,
         * 또 실무로 넘어가면 Entity 클래스 하나가 너무 복잡해질 수도 있음.
         *
         * 그렇기 때문에 받을 데이터만 가지고있는 Validation Check용도의 클래스를 해당 메서드의 Parameter와 같이
         * 따로 생성해주고 관리해주는 것이 좋음
         */

        // Valid 체크한 것이 에러가 있다면...
        if(result.hasErrors()) {
            return "members/createMemberForm";
        }

        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());

        Member member = new Member();
        member.setName(form.getName());
        member.setAddress(address);

        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        MemberListForm memberListForm = new MemberListForm();
        model.addAttribute("members", memberListForm.createReturnMemberList(members));

        return "members/memberList";
    }
}
