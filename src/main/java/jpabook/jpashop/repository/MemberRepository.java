package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository // component scan을 통해 자동으로 spring bean으로 관리
@RequiredArgsConstructor // final로 선언된 필드를 모두 Injection 함, 고로 @PersistenceContext 어노테이션도 필요 없음
public class MemberRepository {

    // @PersistenceContext // EntityManager를 만들어서 Injection함
    // 스프링 Data JPA가 없으면 @RequiredArgsConstructor 말고도 @Autowired, @PersistenceContext 모두 써야 함
    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
