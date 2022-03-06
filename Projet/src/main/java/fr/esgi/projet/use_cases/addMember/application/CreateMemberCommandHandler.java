package fr.esgi.projet.use_cases.addMember.application;

import fr.esgi.projet.kernel.CommandHandler;
import fr.esgi.projet.kernel.Event;
import fr.esgi.projet.kernel.EventDispatcher;
import fr.esgi.projet.use_cases.addMember.domain.*;

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
