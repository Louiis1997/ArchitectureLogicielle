package fr.esgi.projet.use_cases.addMember.application;

import fr.esgi.projet.kernel.EventListener;

public class PaymentEventListener implements EventListener<PaymentEvent> {
    @Override
    public void listenTo(PaymentEvent event) {
        System.out.println("Listening PaymentEvent.");
    }
}
