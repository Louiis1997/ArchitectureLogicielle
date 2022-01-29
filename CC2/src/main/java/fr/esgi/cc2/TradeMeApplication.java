package fr.esgi.cc2;

import fr.esgi.cc2.kernel.NoSuchEntityException;
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
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Timer;

@SpringBootApplication
public class TradeMeApplication {
    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(TradeMeApplication.class, args);

        Timer timer;
        //--1. Apply for Membership
        CreateMemberCommandHandler memberCommandHandler = applicationContext.getBean(CreateMemberCommandHandler.class);
        CreateMember createMember = new CreateMember("Xia", "Sandrine", new Email("sandrine@gmail.com"), "sandrine");
        final MemberId memberId = memberCommandHandler.handle(createMember);

        //--2. Verify Application
        RetrieveMembers retrieveMembers = new RetrieveMembers();
        RetrieveMembersHandler retrieveMembersHandler = applicationContext.getBean(RetrieveMembersHandler.class);
        final List<Member> members = retrieveMembersHandler.handle(retrieveMembers);
        boolean verifyApplication = false;
        for (Member member : members) {
            if (member.getId() == memberId) {
                verifyApplication = true;
                break;
            }
        }
        if(!verifyApplication) throw NoSuchEntityException.withId(memberId);

        //--3. Process Payment
        PaymentCommandHandler paymentCommandHandler = applicationContext.getBean(PaymentCommandHandler.class);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        paymentCommandHandler.handle(new Payment(memberId.getValue(), new PaymentResponse(dtf.format(LocalDateTime.now()))));

        //--1. Apply for Membership
        CreateMember createMember1 = new CreateMember("Xia", "Louis", new Email("lxia1@myges.fr"), "louis", new Job("Ouvrier"), "Paris", 20);
        final MemberId memberId1 = memberCommandHandler.handle(createMember1);

        //--2. Verify Application
        RetrieveMembers retrieveMembers1 = new RetrieveMembers();
        RetrieveMembersHandler retrieveMembersHandler1 = applicationContext.getBean(RetrieveMembersHandler.class);
        final List<Member> members1 = retrieveMembersHandler1.handle(retrieveMembers1);
        boolean verifyApplication1 = false;
        for (Member member : members1) {
            if (member.getId() == memberId1) {
                verifyApplication1 = true;
                break;
            }
        }
        if(!verifyApplication1) throw NoSuchEntityException.withId(memberId1);

        //--3. Process Payment
        paymentCommandHandler.handle(new Payment(memberId1.getValue(), new PaymentResponse(dtf.format(LocalDateTime.now()))));


        //--1. Apply for Membership
        CreateMember createMember2 = new CreateMember("Huang", "Mickael", new Email("mickael@gmail.com"), "mickeal", new Job("Plombier"), "Saint-Denis", 15);
        final MemberId memberId2 = memberCommandHandler.handle(createMember2);

        //--2. Verify Application
        RetrieveMembers retrieveMembers2 = new RetrieveMembers();
        RetrieveMembersHandler retrieveMembersHandler2 = applicationContext.getBean(RetrieveMembersHandler.class);
        final List<Member> members2 = retrieveMembersHandler2.handle(retrieveMembers2);
        boolean verifyApplication2 = false;
        for (Member member : members) {
            if (member.getId() == memberId2) {
                verifyApplication2 = true;
                break;
            }
        }
        if(!verifyApplication2) throw NoSuchEntityException.withId(memberId2);

        //--3. Process Payment
        paymentCommandHandler.handle(new Payment(memberId2.getValue(), new PaymentResponse(dtf.format(LocalDateTime.now()))));


    }
}
