package fr.esgi.projet.use_cases.addMember.application;

import fr.esgi.projet.kernel.ApplicationEvent;
import fr.esgi.projet.use_cases.addMember.domain.MemberId;

public class PaymentEvent implements ApplicationEvent {
    private final MemberId memberId;

    public PaymentEvent(MemberId memberId) {
        this.memberId = memberId;
    }
}
