package fr.esgi.cc2.use_cases.member.application;

import fr.esgi.cc2.kernel.EventListener;

public class PaymentEventListener implements EventListener<PaymentEvent> {
    @Override
    public void listenTo(PaymentEvent event) {
        System.out.println("Listening PaymentEvent.");
    }
}
