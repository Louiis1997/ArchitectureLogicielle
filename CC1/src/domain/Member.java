package domain;

import java.util.Objects;

public final class Member {
    private final MemberId memberId;
    private final String lastname;
    private final String firstname;
    private String email;
    private String password;

    public Member(MemberId memberId, String lastname, String firstname, String email, String password) {
        this.memberId = Objects.requireNonNull(memberId);
        this.lastname = Objects.requireNonNull(lastname);
        this.firstname = Objects.requireNonNull(firstname);
        if(!email.matches(".+@.+\\.[a-z]+"))
            throw new IllegalArgumentException("You must provide a valid email.");
        this.email = Objects.requireNonNull(email);
        this.password = Objects.requireNonNull(password);
    }

    public static Member of(MemberId memberId, String lastname, String firstname, String email, String password) {
        return new Member(memberId, lastname, firstname, email, password);
    }

    public MemberId getMemberId() {
        return memberId;
    }

    public void changePassword(String newPassword) {
        this.password = Objects.requireNonNull(newPassword);
    }

    public void changeEmail(String newEmail) {
        this.email = Objects.requireNonNull(newEmail);
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
