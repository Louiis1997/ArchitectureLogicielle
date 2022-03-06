package fr.esgi.projet.use_cases.createProject.infrastructure;

import fr.esgi.projet.kernel.NoSuchEntityException;
import fr.esgi.projet.use_cases.createProject.domain.Project;
import fr.esgi.projet.use_cases.createProject.domain.ProjectId;
import fr.esgi.projet.use_cases.createProject.domain.ProjectRepository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryProjectRepository implements ProjectRepository {
    private final AtomicInteger count = new AtomicInteger(0);

    private final Map<ProjectId, Project> data = new ConcurrentHashMap<>();

    @Override
    public ProjectId nextIdentity() {
        return new ProjectId(count.incrementAndGet());
    }

    @Override
    public Project findById(ProjectId id) {
        final Project project = data.get(id);
        if (project == null) {
            throw NoSuchEntityException.withId(id);
        }
        return project;
    }

    @Override
    public void add(Project project) {
        data.put(project.getId(), project);
    }

    @Override
    public void delete(ProjectId id) {
        data.remove(id);
    }

    @Override
    public List<Project> findAll() {
        return List.copyOf(data.values());
    }
}
