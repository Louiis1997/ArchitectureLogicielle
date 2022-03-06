package fr.esgi.projet.use_cases.createProject.application;

import fr.esgi.projet.kernel.ApplicationEvent;
import fr.esgi.projet.use_cases.createProject.domain.ProjectId;

public class CreateProjectEvent implements ApplicationEvent {
    private final ProjectId projectId;

    public CreateProjectEvent(ProjectId projectId) {
        this.projectId = projectId;
    }
}
