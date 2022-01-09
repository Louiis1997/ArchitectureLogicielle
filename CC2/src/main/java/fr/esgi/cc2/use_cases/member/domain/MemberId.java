package fr.esgi.cc2.use_cases.member.domain;

import fr.esgi.cc2.kernel.ValueObjectID;
import java.util.Objects;

public final class MemberId implements ValueObjectID {
    private final int value;

    public MemberId(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberId memberId = (MemberId) o;
        return value == memberId.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "MemberId{" +
                "value=" + value +
                '}';
    }
}
