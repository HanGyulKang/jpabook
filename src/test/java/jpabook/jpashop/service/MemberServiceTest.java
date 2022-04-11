package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class) // Spring이랑 같이 엮어서 실행 하겠다.
@SpringBootTest // 스프링부트 컨테이너 안에서 테스트를 돌리기 위함
@Transactional // 트랜잭션을 걸어서 테스트가 끝나면 모두 롤백하기 위함 ( Service, Repository같은 곳에 붙이면 롤백을 안 함)
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    EntityManager em;

    @Test
    // @Rollback(value = false) : 해당 어노테이션을 사용하게되면 트랜잭션 강제 롤백을 방지한다.
    public void 회원가입() throws Exception {
        // given
        Member member = new Member();
        member.setName("kim");

        // when
        Long id = memberService.join(member);

        // then
        em.flush(); // 영속성 컨텍스트에 있는 변경 또는 등록건을 강제로 DB에 날림 = Insert 함
        Assert.assertEquals(member, memberRepository.findOne(id));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("kim");
        Member member2 = new Member();
        member2.setName("kim");

        // when
        memberService.join(member1);
//        try {
        memberService.join(member2); // 예외가 발생해야 한다.
//        } catch (IllegalStateException e) {
//            return;
//        }

        // then
        Assert.fail("예외 발생");
    }

}