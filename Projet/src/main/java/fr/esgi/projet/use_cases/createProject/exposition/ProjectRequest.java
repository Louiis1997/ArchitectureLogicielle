package fr.esgi.projet.use_cases.createProject.exposition;

import fr.esgi.projet.use_cases.createProject.domain.Contractor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
public class ProjectRequest {
    @NotNull
    @NotBlank
    public Contractor contractor;
}
