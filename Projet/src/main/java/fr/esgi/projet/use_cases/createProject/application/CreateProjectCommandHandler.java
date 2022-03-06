package fr.esgi.projet.use_cases.createProject.application;

import fr.esgi.projet.kernel.CommandHandler;
import fr.esgi.projet.kernel.Event;
import fr.esgi.projet.kernel.EventDispatcher;
import fr.esgi.projet.use_cases.createProject.domain.*;

public final class CreateProjectCommandHandler implements CommandHandler<CreateProject, ProjectId> {
    private final ProjectRepository projectRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public CreateProjectCommandHandler(ProjectRepository projectRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.projectRepository = projectRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    public ProjectId handle(CreateProject createProject) {
        final ProjectId projectId = projectRepository.nextIdentity();
        Project project = new Project(projectId, createProject.contractor, createProject.tradesmen, createProject.jobs, createProject.skills, createProject.localisation, createProject.billRate, createProject.duration);
        createProject.contractor.addProject(project);
        projectRepository.add(project);
        eventEventDispatcher.dispatch(new CreateProjectEvent(projectId));
        return projectId;
    }
}
