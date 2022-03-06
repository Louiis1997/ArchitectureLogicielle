package fr.esgi.projet.use_cases.addMember.application;

import fr.esgi.projet.kernel.ApplicationEvent;
import fr.esgi.projet.use_cases.addMember.domain.MemberId;

public class CreateMemberEvent implements ApplicationEvent {
    private final MemberId memberId;

    public CreateMemberEvent(MemberId memberId) {
        this.memberId = memberId;
    }
}
