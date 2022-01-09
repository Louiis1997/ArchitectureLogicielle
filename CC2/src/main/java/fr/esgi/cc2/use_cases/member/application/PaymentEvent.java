package fr.esgi.cc2.use_cases.member.application;

import fr.esgi.cc2.kernel.ApplicationEvent;
import fr.esgi.cc2.use_cases.member.domain.MemberId;

public class PaymentEvent implements ApplicationEvent {
    private final MemberId memberId;

    public PaymentEvent(MemberId memberId) {
        this.memberId = memberId;
    }
}
