package fr.esgi.projet;

import fr.esgi.projet.kernel.*;
import fr.esgi.projet.use_cases.createProject.application.*;
import fr.esgi.projet.use_cases.createProject.domain.ProjectRepository;
import fr.esgi.projet.use_cases.createProject.infrastructure.DefaultProjectEventDispatcher;
import fr.esgi.projet.use_cases.createProject.infrastructure.InMemoryProjectRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ProjectConfiguration {
    @Bean
    public ProjectRepository projectRepository() {
        return new InMemoryProjectRepository();
    }

    @Bean
    public EventDispatcher<Event> projectEventEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(CreateProjectEvent.class, List.of(new CreateProjectEventListener()));
        return new DefaultProjectEventDispatcher(listenerMap);
    }

    @Bean
    public CreateProjectCommandHandler createProjectCommandHandler() {
        return new CreateProjectCommandHandler(projectRepository(), projectEventEventDispatcher());
    }

    @Bean
    public CommandBus projectCommandBus() {
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap =
                Collections.singletonMap(CreateProject.class, new CreateProjectCommandHandler(projectRepository(), projectEventEventDispatcher()));
        return new SimpleCommandBus(commandHandlerMap);
    }

    @Bean
    public QueryBus projectQueryBus() {
        final Map<Class<? extends Query>, QueryHandler> queryHandlerMap =
                Collections.singletonMap(RetrieveProjects.class, new RetrieveProjectsHandler(projectRepository()));
        return new SimpleQueryBus(queryHandlerMap);
    }

    @Bean
    public RetrieveProjectsHandler retrieveProjectsHandler() {
        return new RetrieveProjectsHandler(projectRepository());
    }
}
