package fr.esgi.projet.use_cases.closeProject.application;

import fr.esgi.projet.kernel.ApplicationEvent;
import fr.esgi.projet.use_cases.createProject.domain.ProjectId;

public class CloseProjectEvent implements ApplicationEvent {
    private final ProjectId projectId;

    public CloseProjectEvent(ProjectId projectId) {
        this.projectId = projectId;
    }
}
