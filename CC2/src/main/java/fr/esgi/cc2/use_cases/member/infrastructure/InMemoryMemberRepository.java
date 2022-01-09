package fr.esgi.cc2.use_cases.member.infrastructure;

import fr.esgi.cc2.kernel.NoSuchEntityException;
import fr.esgi.cc2.use_cases.member.domain.Member;
import fr.esgi.cc2.use_cases.member.domain.MemberId;
import fr.esgi.cc2.use_cases.member.domain.MemberRepository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class InMemoryMemberRepository implements MemberRepository {
    private final AtomicInteger count = new AtomicInteger(0);

    private final Map<MemberId, Member> data = new ConcurrentHashMap<>();

    @Override
    public MemberId nextIdentity() {
        return new MemberId(count.incrementAndGet());
    }

    @Override
    public Member findById(MemberId id) {
        final Member member = data.get(id);
        if (member == null) {
            throw NoSuchEntityException.withId(id);
        }
        return member;
    }

    @Override
    public void add(Member member) {
        data.put(member.getId(), member);
    }

    @Override
    public void delete(MemberId id) {
        data.remove(id);
    }

    @Override
    public List<Member> findAll() {
        return List.copyOf(data.values());
    }
}
