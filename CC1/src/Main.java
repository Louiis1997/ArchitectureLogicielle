import domain.*;
import infrastructure.InMemoryMemberRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MemberRepository memberRepository = new InMemoryMemberRepository();
        MemberService memberService = new MemberService(memberRepository);

        final MemberId sandrine = memberRepository.nextId();
        applyMembership(memberService, sandrine, "Xia", "Sandrine", "sandrine@gmail.com", "sandrine");

        final MemberId mickael = memberRepository.nextId();
        applyMembership(memberService, mickael, "Huang", "Mickael", "MickaelH@hotmail.fr", "mickmick");

        final MemberId myMemberId = memberRepository.nextId();
        applyMembership(memberService, myMemberId, "Xia", "Louis", "lxia1@myges.fr", "louis");

        final MemberId None = memberRepository.nextId();
        if(verifApplication(memberService, myMemberId)) {

        } else {
            throw new IllegalStateException("You're not a Member !");
        }
    }

    private static void applyMembership(MemberService memberService, MemberId memberId, String lastname, String name, String email, String password) {
        Member member = Member.of(memberId, lastname, name, email, password);
        memberService.apply(member);
    }

    private static void changePassword(MemberService memberService, MemberId memberId, String newPassword) {
        memberService.changePassword(memberId, newPassword);
    }

    private static void changeEmail(MemberService memberService, MemberId memberId, String newEmail) {
        memberService.changeEmail(memberId, newEmail);
    }

    private static boolean verifApplication(MemberService memberService, MemberId memberId) {
        try {
            memberService.isMember(memberId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static void printAllMembers(MemberService memberService) {
        System.out.println("List all members");

        final List<Member> members = memberService.all();
        members.forEach(System.out::println);
    }
}
