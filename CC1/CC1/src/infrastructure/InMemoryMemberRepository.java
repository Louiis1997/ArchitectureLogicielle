package infrastructure;

import domain.Member;
import domain.MemberId;
import domain.MemberRepository;
import domain.NoSuchMemberException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryMemberRepository implements MemberRepository{
    private final AtomicInteger counter = new AtomicInteger(0);
    private final Map<MemberId, Member> data = new ConcurrentHashMap<>();

    @Override
    public void save(Member member) {
        data.put(member.getMemberId(), member);
    }

    @Override
    public Member byId(MemberId memberId) {
        final Member member = data.get(memberId);
        if (member == null) {
            throw NoSuchMemberException.withId(memberId);
        }
        return member;
    }

    @Override
    public MemberId nextId() {
        return MemberId.of(counter.incrementAndGet());
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(data.values());
    }
}
