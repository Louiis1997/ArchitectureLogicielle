package fr.esgi.projet.use_cases.closeProject.application;

import fr.esgi.projet.kernel.CommandHandler;
import fr.esgi.projet.kernel.Event;
import fr.esgi.projet.kernel.EventDispatcher;
import fr.esgi.projet.kernel.NoSuchEntityException;
import fr.esgi.projet.use_cases.closeProject.domain.Contractor;
import fr.esgi.projet.use_cases.closeProject.domain.Project;
import fr.esgi.projet.use_cases.createProject.domain.ProjectId;
import fr.esgi.projet.use_cases.closeProject.domain.ProjectRepository;

public final class CloseProjectCommandHandler implements CommandHandler<CloseProject, ProjectId> {
    private final ProjectRepository projectRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public CloseProjectCommandHandler(ProjectRepository projectRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.projectRepository = projectRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    public ProjectId handle(CloseProject command) {
        Project project = projectRepository.findById(command.projectId);
        Contractor contractor = project.getContractor();
        project.fireAllTradesmen();
        contractor.removeProject(project);
        projectRepository.delete(project.id());
        eventEventDispatcher.dispatch(new CloseProjectEvent(command.projectId));
        return command.projectId;
    }
}
