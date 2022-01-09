package fr.esgi.cc2.use_cases.member.application;

import fr.esgi.cc2.kernel.Command;
import fr.esgi.cc2.use_cases.member.domain.*;

import java.util.Objects;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class CreateMember implements Command {
    public final String lastname;
    public final String firstname;
    public Email email;
    public String password;
    public final Role role;
    public Job job;
    public String area;
    public int billRate;
    public String creditCard;

    public CreateMember(String lastname, String firstname, Email email, String password, Job job, String area, int billRate) {
        this.lastname = Objects.requireNonNull(lastname);
        this.firstname = Objects.requireNonNull(firstname);
        this.email = Objects.requireNonNull(email);
        this.password = Objects.requireNonNull(password);
        this.role = new Tradesman(job, area, billRate);
        this.job = job;
        this.area = area;
        this.billRate = billRate;
        this.creditCard = null;
    }

    public CreateMember(String lastname, String firstname,Email email, String password) {
        this.lastname = Objects.requireNonNull(lastname);
        this.firstname = Objects.requireNonNull(firstname);
        this.email = Objects.requireNonNull(email);
        this.password = Objects.requireNonNull(password);
        this.role = new Contractor();
        this.creditCard = null;
    }
}