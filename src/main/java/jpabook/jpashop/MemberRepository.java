package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {
    @PersistenceContext
    private EntityManager em;
    // entity manager를 통한 모든 데이터 변경은 transaction 안에서만 이루어져야함

    public Integer save(Member member){
        em.persist(member);
        return member.getId();
    }

    public Member find(Integer id){
        return em.find(Member.class, id);
    }
}
// shift + ctrl + T : 유닛테스트 만들어주기