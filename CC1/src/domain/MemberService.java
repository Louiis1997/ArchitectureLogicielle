package domain;

import java.util.List;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void apply(Member member) {
        this.memberRepository.save(member);
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

    public void isMember(MemberId memberId) {
        this.memberRepository.byId(memberId);
    }

    public List<Member> all() {
        return this.memberRepository.findAll();
    }
}
