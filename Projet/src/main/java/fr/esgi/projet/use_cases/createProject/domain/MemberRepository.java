package fr.esgi.projet.use_cases.createProject.domain;

import fr.esgi.projet.kernel.Repository;

import java.util.List;

public interface MemberRepository extends Repository<MemberId, Member> {
    List<Member> findAll();
}
