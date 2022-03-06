package fr.esgi.projet.use_cases.closeProject.domain;

import fr.esgi.projet.kernel.Entity;

import java.util.Objects;

public final class Member implements Entity<MemberId> {
    private final MemberId id;
    private final String lastname;
    private final String firstname;
    private Email email;
    private String password;
    private final Role role;
    private String creditCard;
    private String lastPayment;

    public Member(MemberId id, String lastname, String firstname, Email email, String password, Job job, String area, int billRate) {
        this.id = Objects.requireNonNull(id);
        this.lastname = Objects.requireNonNull(lastname);
        this.firstname = Objects.requireNonNull(firstname);
        this.email = Objects.requireNonNull(email);
        this.password = Objects.requireNonNull(password);
        this.role = new Tradesman(job, area, billRate);
        this.creditCard = null;
        this.lastPayment = null;
    }

    public Member(MemberId id, String lastname, String firstname, Email email, String password) {
        this.id = Objects.requireNonNull(id);
        this.lastname = Objects.requireNonNull(lastname);
        this.firstname = Objects.requireNonNull(firstname);
        this.email = Objects.requireNonNull(email);
        this.password = Objects.requireNonNull(password);
        this.role = new Contractor();
        this.creditCard = null;
        this.lastPayment = null;
    }

    public MemberId getId() {
        return id;
    }

    @Override
    public MemberId id() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public Email getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public String getLastPayment() {
        return lastPayment;
    }

    public void changePassword(String newPassword) {
        this.password = Objects.requireNonNull(newPassword);
    }

    public void changeEmail(Email newEmail) {
        this.email = Objects.requireNonNull(newEmail);
    }

    public void changeCreditCard(String newCreditCard) {
        this.creditCard = Objects.requireNonNull(newCreditCard);
    }

    public void changeLastPayment(String newLastPayment) {
        this.lastPayment = Objects.requireNonNull(newLastPayment);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(id, member.id) && Objects.equals(lastname, member.lastname) && Objects.equals(firstname, member.firstname) && Objects.equals(password, member.password) && Objects.equals(email, member.email) && Objects.equals(creditCard, member.creditCard) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastname, firstname, email, creditCard);
    }

    @Override
    public String toString() {
        return "Member{" +
                "MemberId=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
