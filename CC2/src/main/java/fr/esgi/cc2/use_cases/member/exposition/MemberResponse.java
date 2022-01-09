package fr.esgi.cc2.use_cases.member.exposition;

import fr.esgi.cc2.use_cases.member.domain.Contractor;
import fr.esgi.cc2.use_cases.member.domain.Role;

import java.util.Objects;

public class MemberResponse {
    public String id;
    public String lastname;
    public String firstname;
    public EmailResponse email;
    public String password;
    public Role role;
    public String creditCard;

    public MemberResponse(String id, String lastname, String firstname, EmailResponse email, String password, Role role, String creditCard) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.creditCard = creditCard;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", email=" + email +
                '}';
    }
}
