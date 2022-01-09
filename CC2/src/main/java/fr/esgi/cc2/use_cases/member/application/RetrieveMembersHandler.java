package fr.esgi.cc2.use_cases.member.application;

import fr.esgi.cc2.kernel.QueryHandler;
import fr.esgi.cc2.use_cases.member.domain.Member;
import fr.esgi.cc2.use_cases.member.domain.MemberRepository;

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

