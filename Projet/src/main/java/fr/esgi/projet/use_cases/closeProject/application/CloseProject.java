package fr.esgi.projet.use_cases.closeProject.application;

import fr.esgi.projet.kernel.Command;
import fr.esgi.projet.use_cases.createProject.domain.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class CloseProject implements Command {
    public final ProjectId projectId;

    public CloseProject(ProjectId projectId){
        this.projectId = projectId;
    }

}
