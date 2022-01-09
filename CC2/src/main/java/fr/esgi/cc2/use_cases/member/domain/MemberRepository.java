package fr.esgi.cc2.use_cases.member.domain;

import fr.esgi.cc2.kernel.Repository;

import java.util.List;

public interface MemberRepository extends Repository<MemberId, Member> {
    List<Member> findAll();
}
