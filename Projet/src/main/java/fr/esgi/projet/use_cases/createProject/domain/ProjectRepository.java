package fr.esgi.projet.use_cases.createProject.domain;

import fr.esgi.projet.kernel.Repository;

import java.util.List;

public interface ProjectRepository extends Repository<ProjectId, Project> {
    List<Project> findAll();
}

