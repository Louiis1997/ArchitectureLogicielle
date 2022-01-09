package fr.esgi.cc2;

import fr.esgi.cc2.use_cases.member.application.*;
import fr.esgi.cc2.use_cases.member.domain.Email;
import fr.esgi.cc2.use_cases.member.domain.Job;
import fr.esgi.cc2.use_cases.member.domain.Member;
import fr.esgi.cc2.use_cases.member.domain.MemberId;
import fr.esgi.cc2.use_cases.member.exposition.PaymentResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootApplication
public class TradeMeApplication {
    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(TradeMeApplication.class, args);

        //--1. Apply for Membership
        CreateMemberCommandHandler memberCommandHandler = applicationContext.getBean(CreateMemberCommandHandler.class);
        CreateMember createMember = new CreateMember("Xia", "Sandrine", new Email("sandrine@gmail.com"), "sandrine");
        final MemberId memberId = memberCommandHandler.handle(createMember);

        CreateMember createMember1 = new CreateMember("Xia", "Louis", new Email("lxia1@myges.fr"), "louis", new Job("Ouvrier"), "Paris", 20);
        final MemberId memberId1 = memberCommandHandler.handle(createMember1);

        CreateMember createMember2 = new CreateMember("Huang", "Mickael", new Email("mickael@gmail.com"), "mickeal", new Job("Plombier"), "Saint-Denis", 15);
        final MemberId memberId2 = memberCommandHandler.handle(createMember2);

        //--2. Verify Application
        RetrieveMembers retrieveMembers = new RetrieveMembers();
        RetrieveMembersHandler retrieveMembersHandler = applicationContext.getBean(RetrieveMembersHandler.class);
        final List<Member> members = retrieveMembersHandler.handle(retrieveMembers);
        members.forEach(System.out::println);

        //--3. Process Payment
        PaymentCommandHandler paymentCommandHandler = applicationContext.getBean(PaymentCommandHandler.class);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        paymentCommandHandler.handle(new Payment(memberId.getValue(), new PaymentResponse(dtf.format(LocalDateTime.now()))));
    }
}
