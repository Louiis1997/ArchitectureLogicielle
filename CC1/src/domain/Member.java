package domain;

import java.util.Objects;

public final class Member {
    private final MemberId memberId;
    private final String lastname;
    private final String firstname;
    private String email;
    private String password;
    private String creditCard;

    public Member(MemberId memberId, String lastname, String firstname, String email, String password) {
        this.memberId = Objects.requireNonNull(memberId);
        this.lastname = Objects.requireNonNull(lastname);
        this.firstname = Objects.requireNonNull(firstname);
        if(!email.matches(".+@.+\\.[a-z]+"))
            throw new IllegalArgumentException("You must provide a valid email.");
        this.email = Objects.requireNonNull(email);
        this.password = Objects.requireNonNull(password);
        this.creditCard = null;
    }

    public static Member of(MemberId memberId, String lastname, String firstname, String email, String password) {
        return new Member(memberId, lastname, firstname, email, password);
    }

    public MemberId getMemberId() {
        return memberId;
    }

    public String getEmail() {
        return email;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void changePassword(String newPassword) {
        this.password = Objects.requireNonNull(newPassword);
    }

    public void changeEmail(String newEmail) {
        this.email = Objects.requireNonNull(newEmail);
    }

    public void changeCrefitCard(String newCreditCard) {
        this.creditCard = Objects.requireNonNull(newCreditCard);
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
