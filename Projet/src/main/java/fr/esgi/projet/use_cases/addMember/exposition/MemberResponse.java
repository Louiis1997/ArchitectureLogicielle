package fr.esgi.projet.use_cases.addMember.exposition;

import fr.esgi.projet.use_cases.addMember.domain.Role;

public class MemberResponse {
    public String id;
    public String lastname;
    public String firstname;
    public EmailResponse email;
    public String password;
    public Role role;
    public String creditCard;
    public String lastPayment;

    public MemberResponse(String id, String lastname, String firstname, EmailResponse email, String password, Role role, String creditCard, String lastPayment) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.creditCard = creditCard;
        this.lastPayment = lastPayment;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", email=" + email + '\'' +
                ", password=" + password + '\'' +
                ", role=" + role + '\'' +
                ", credit card=" + creditCard + '\'' +
                '}';
    }
}
