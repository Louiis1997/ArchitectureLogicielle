package fr.esgi.projet.use_cases.closeProject.application;

import fr.esgi.projet.kernel.Query;
import fr.esgi.projet.use_cases.createProject.domain.ProjectId;

public class RetrieveProject implements Query {
    ProjectId id;

    public RetrieveProject(ProjectId id) {
        this.id = id;
    }
}
