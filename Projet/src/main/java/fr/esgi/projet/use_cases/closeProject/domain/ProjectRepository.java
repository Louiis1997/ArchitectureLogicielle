package fr.esgi.projet.use_cases.closeProject.domain;

import fr.esgi.projet.kernel.Repository;

import java.util.List;

public interface ProjectRepository extends Repository<fr.esgi.projet.use_cases.createProject.domain.ProjectId, Project> {
    List<Project> findAll();
}

