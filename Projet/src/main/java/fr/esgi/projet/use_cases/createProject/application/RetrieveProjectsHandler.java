package fr.esgi.projet.use_cases.createProject.application;

import fr.esgi.projet.kernel.QueryHandler;
import fr.esgi.projet.use_cases.createProject.domain.Project;
import fr.esgi.projet.use_cases.createProject.domain.ProjectRepository;

import java.util.List;

public class RetrieveProjectsHandler implements QueryHandler<RetrieveProjects, List<Project>> {
    private final ProjectRepository projectRepository;

    public RetrieveProjectsHandler(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> handle(RetrieveProjects query) {
        return projectRepository.findAll();
    }
}
