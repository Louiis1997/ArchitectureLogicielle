package domain;

import java.util.List;
import java.util.Scanner;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void apply(Member member) {
        this.memberRepository.save(member);
    }

    public Member getMember(MemberId memberId) {
        return this.memberRepository.byId(memberId);
    }

    public void payment(MemberId memberId) {
        var member = this.memberRepository.byId(memberId);
        Scanner scanner = new Scanner(System.in);
        if(member.getCreditCard() == null){
            System.out.print("Please provide your credit card number : ");
            changeCreditCard(memberId,scanner.next());
        }
        System.out.println("You are sure you wanna buy the subscription ? Yes/No");
        if(!scanner.next().equals("Yes"))
            System.exit(1);
        System.out.print("Congrats for your subscription!");
    }

    public void changePassword(MemberId memberId, String newPassword) {
        var member = this.memberRepository.byId(memberId);
        member.changePassword(newPassword);
        this.memberRepository.save(member);
    }

    public void changeEmail(MemberId memberId, String newEmail) {
        var member = this.memberRepository.byId(memberId);
        member.changeEmail(newEmail);
        this.memberRepository.save(member);
    }

    public void changeCreditCard(MemberId memberId, String newCreditCard) {
        var member = this.memberRepository.byId(memberId);
        member.changeCrefitCard(newCreditCard);
        this.memberRepository.save(member);
    }

    public List<Member> all() {
        return this.memberRepository.findAll();
    }
}
