package fr.esgi.projet.use_cases.addMember.application;

import fr.esgi.projet.kernel.Command;
import fr.esgi.projet.use_cases.addMember.exposition.PaymentResponse;

public class Payment implements Command {
    public final int memberId;
    public final PaymentResponse payment;

    public Payment(int memberId, PaymentResponse payment) {
        this.memberId = memberId;
        this.payment = payment;
    }
}
