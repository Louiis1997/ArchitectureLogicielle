package fr.esgi.projet.use_cases.closeProject.exposition;

import fr.esgi.projet.use_cases.closeProject.domain.Contractor;
import fr.esgi.projet.use_cases.createProject.domain.ProjectId;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProjectRequest {
    @NotNull
    @NotBlank
    public ProjectId projectId;
}
