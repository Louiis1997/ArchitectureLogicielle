package fr.esgi.projet.use_cases.addMember.application;

import fr.esgi.projet.kernel.CommandHandler;
import fr.esgi.projet.kernel.Event;
import fr.esgi.projet.kernel.EventDispatcher;
import fr.esgi.projet.use_cases.addMember.domain.MemberId;
import fr.esgi.projet.use_cases.addMember.domain.MemberRepository;

import java.util.Scanner;

public class PaymentCommandHandler implements CommandHandler<Payment, Void>{
    MemberRepository memberRepository;
    EventDispatcher<Event> eventEventDispatcher;

    public PaymentCommandHandler(MemberRepository memberRepository, EventDispatcher<Event> eventEventDispatcher){
        this.memberRepository = memberRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public Void handle(Payment command) {
        var memberId = new MemberId(command.memberId);
        var member = memberRepository.findById(memberId);
        Scanner scanner = new Scanner(System.in);
        if (member.getCreditCard() == null) {
            System.out.print("Please provide your credit card number : ");
            member.changeCreditCard(scanner.next());
        }
        System.out.println("You are sure you wanna buy/renew the subscription ? Yes/No");
        if (!scanner.next().equals("Yes"))
            System.exit(1);
        System.out.print("Congrats for your subscription!\n");
        var lastPayment = command.payment.lastPayment;
        member.changeLastPayment(lastPayment);
        memberRepository.add(member);
        eventEventDispatcher.dispatch(new PaymentEvent(memberId));
        return null;
    }
}
