package fr.esgi.cc2.use_cases.member.application;

import fr.esgi.cc2.kernel.Command;
import fr.esgi.cc2.use_cases.member.exposition.PaymentResponse;

public class Payment implements Command {
    public final int memberId;
    public final PaymentResponse payment;

    public Payment(int memberId, PaymentResponse payment) {
        this.memberId = memberId;
        this.payment = payment;
    }
}
