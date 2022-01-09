package fr.esgi.cc2.use_cases.member.application;

import fr.esgi.cc2.kernel.CommandHandler;
import fr.esgi.cc2.kernel.Event;
import fr.esgi.cc2.kernel.EventDispatcher;
import fr.esgi.cc2.use_cases.member.domain.MemberId;
import fr.esgi.cc2.use_cases.member.domain.MemberRepository;

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
        System.out.println("You are sure you wanna buy the subscription ? Yes/No");
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
