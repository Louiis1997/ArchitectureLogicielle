package fr.esgi.projet.use_cases.addMember.application;

import fr.esgi.projet.kernel.QueryHandler;
import fr.esgi.projet.use_cases.addMember.domain.Member;
import fr.esgi.projet.use_cases.addMember.domain.MemberRepository;

import java.util.List;

public class RetrieveMembersHandler implements QueryHandler<RetrieveMembers, List<Member>> {

    private final MemberRepository memberRepository;

    public RetrieveMembersHandler(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> handle(RetrieveMembers query) {
        return memberRepository.findAll();
    }
}

