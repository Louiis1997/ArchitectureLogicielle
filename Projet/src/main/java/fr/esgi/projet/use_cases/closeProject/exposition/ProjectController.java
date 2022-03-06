package fr.esgi.projet.use_cases.closeProject.exposition;

import fr.esgi.projet.kernel.CommandBus;
import fr.esgi.projet.kernel.QueryBus;
import fr.esgi.projet.use_cases.closeProject.application.CloseProject;
import fr.esgi.projet.use_cases.closeProject.application.RetrieveProject;
import fr.esgi.projet.use_cases.closeProject.application.RetrieveProjects;
import fr.esgi.projet.use_cases.closeProject.domain.Project;
import fr.esgi.projet.use_cases.createProject.domain.ProjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
@RestController
public class ProjectController {
    private final CommandBus commandBus;
    private final QueryBus queryBus;

    public ProjectController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @GetMapping(path = "/projects", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProjectsResponse> getAll() {
        final List<Project> projects = queryBus.send(new RetrieveProjects());
        ProjectsResponse projectsResponseResult = new ProjectsResponse(projects.stream().map(project -> new ProjectResponse(String.valueOf(project.getId().getValue()), new ContractorResponse(project.getContractor()), new TradesmenResponse(project.getTradesmen()), new JobsResponse(project.getJobs()), new SkillsResponse(project.getSkills()), project.getLocalisation(), project.getBillRate(), project.getDuration())).collect(Collectors.toList()));
        return ResponseEntity.ok(projectsResponseResult);
    }

    @GetMapping(path = "/project", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProjectResponse> getOne(@RequestParam int id) {
        final Project project = queryBus.send(new RetrieveProject(new ProjectId(id)));
        ProjectResponse projectResponseResult = new ProjectResponse(String.valueOf(project.getId().getValue()), new ContractorResponse(project.getContractor()), new TradesmenResponse(project.getTradesmen()), new JobsResponse(project.getJobs()), new SkillsResponse(project.getSkills()), project.getLocalisation(), project.getBillRate(), project.getDuration());
        return ResponseEntity.ok(projectResponseResult);
    }

    @PostMapping(path = "/project", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> close(@RequestBody @Valid ProjectRequest request) {
        CloseProject closeProject = new CloseProject(request.projectId);
        commandBus.send(closeProject);
        return ResponseEntity.ok().build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}

