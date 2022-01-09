package fr.esgi.cc2.use_cases.member.application;

import fr.esgi.cc2.kernel.CommandHandler;
import fr.esgi.cc2.kernel.Event;
import fr.esgi.cc2.kernel.EventDispatcher;
import fr.esgi.cc2.use_cases.member.domain.*;

public final class CreateMemberCommandHandler implements CommandHandler<CreateMember, MemberId> {

    private final MemberRepository memberRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public CreateMemberCommandHandler(MemberRepository memberRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.memberRepository = memberRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    public MemberId handle(CreateMember createMember) {
        final MemberId memberId = memberRepository.nextIdentity();
        Member member;
        if(createMember.job != null)
            member = new Member(memberId, createMember.lastname, createMember.firstname, new Email(createMember.email.getEmail()), createMember.password, createMember.job, createMember.area, createMember.billRate);
        else
            member = new Member(memberId, createMember.lastname, createMember.firstname, new Email(createMember.email.getEmail()), createMember.password);
        memberRepository.add(member);
        eventEventDispatcher.dispatch(new CreateMemberEvent(memberId));
        return memberId;
    }
}
