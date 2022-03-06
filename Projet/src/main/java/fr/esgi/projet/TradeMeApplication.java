package fr.esgi.projet;

import fr.esgi.projet.kernel.NoSuchEntityException;
import fr.esgi.projet.use_cases.addMember.application.*;
import fr.esgi.projet.use_cases.addMember.domain.*;
import fr.esgi.projet.use_cases.addMember.exposition.PaymentResponse;
import fr.esgi.projet.use_cases.closeProject.application.CloseProject;
import fr.esgi.projet.use_cases.closeProject.application.CloseProjectCommandHandler;
import fr.esgi.projet.use_cases.closeProject.application.RetrieveProject;
import fr.esgi.projet.use_cases.createProject.application.*;
import fr.esgi.projet.use_cases.createProject.domain.ProjectId;
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
        CreateMemberCommandHandler memberCommandHandler = applicationContext.getBean(CreateMemberCommandHandler.class);
        CreateProjectCommandHandler projectCommandHandler = applicationContext.getBean(CreateProjectCommandHandler.class);
        CloseProjectCommandHandler closeProjectCommandHandler = applicationContext.getBean(CloseProjectCommandHandler.class);
        //--1. Apply for Membership
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
        for (Member member : members2) {
            if (member.getId() == memberId2) {
                verifyApplication2 = true;
                break;
            }
        }
        if(!verifyApplication2) throw NoSuchEntityException.withId(memberId2);

        //--3. Process Payment
        paymentCommandHandler.handle(new Payment(memberId2.getValue(), new PaymentResponse(dtf.format(LocalDateTime.now()))));

        //--1. Request Create Project
        fr.esgi.projet.use_cases.createProject.domain.Contractor contractor = new fr.esgi.projet.use_cases.createProject.domain.Contractor();
        CreateProject createProject = new CreateProject(contractor);
        final ProjectId projectId = projectCommandHandler.handle(createProject);

        //--2. Verify Request
        RetrieveProjects retrieveProjects = new RetrieveProjects();
        RetrieveProjectsHandler retrieveProjectsHandler = applicationContext.getBean(RetrieveProjectsHandler.class);
        final List<fr.esgi.projet.use_cases.createProject.domain.Project> projects = retrieveProjectsHandler.handle(retrieveProjects);
        boolean verifyRequest = false;
        for(fr.esgi.projet.use_cases.createProject.domain.Project project : projects) {
            if(project.getId() == projectId) {
                verifyRequest = true;
                break;
            }
        }
        if(!verifyRequest) throw NoSuchEntityException.withId(projectId);

        //--3. Add Required Trades, Skills, Bill Rates, Location, Duration
        fr.esgi.projet.use_cases.createProject.domain.Job plombier = new fr.esgi.projet.use_cases.createProject.domain.Job("Plombier");
        fr.esgi.projet.use_cases.createProject.domain.Job charpentier = new fr.esgi.projet.use_cases.createProject.domain.Job("Charpentier");
        createProject.jobs.add(plombier);
        createProject.jobs.add(charpentier);
        createProject.skills.add(new fr.esgi.projet.use_cases.createProject.domain.Skill("Soudure"));
        createProject.skills.add(new fr.esgi.projet.use_cases.createProject.domain.Skill("Toiture"));
        createProject.billRate.put(plombier,12);
        createProject.billRate.put(charpentier,20);
        projects.get(projectId.getValue()-1).setLocalisation("Paris");
        projects.get(projectId.getValue()-1).setDuration(5);

        //--4. Active Project
        for(fr.esgi.projet.use_cases.createProject.domain.Project project : projects) {
            if(project.getId() == projectId) {
                System.out.println(project);
            }
        }

        //--1. Request Close Project
        CloseProject closeProject = new CloseProject(projectId);

        //--2. Verify Request
        RetrieveProjects retrieveProjects2 = new RetrieveProjects();
        RetrieveProjectsHandler retrieveProjectsHandler2 = applicationContext.getBean(RetrieveProjectsHandler.class);
        final List<fr.esgi.projet.use_cases.createProject.domain.Project> projects2 = retrieveProjectsHandler.handle(retrieveProjects);
        boolean verifyRequest2 = true;
        for(fr.esgi.projet.use_cases.createProject.domain.Project project : projects) {
            if(project.getId() == projectId) {
                verifyRequest2 = false;
                break;
            }
        }
        if(!verifyRequest2) throw NoSuchEntityException.withId(projectId);

        //--3. Release all tradesmen and close project
        closeProjectCommandHandler.handle(closeProject);


    }
}
