package fr.esgi.projet.use_cases.closeProject.exposition;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@SuppressWarnings("all")
@XmlRootElement
public class ProjectsResponse {
    public final List<ProjectResponse> projects;

    public ProjectsResponse(List<ProjectResponse> projects) {
        this.projects = projects;
    }
}
