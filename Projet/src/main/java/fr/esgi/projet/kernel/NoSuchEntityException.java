package fr.esgi.projet.kernel;

import fr.esgi.projet.use_cases.addMember.domain.MemberId;
import fr.esgi.projet.use_cases.createProject.domain.ProjectId;

public final class NoSuchEntityException extends RuntimeException {

    public NoSuchEntityException(String message) {
        super(message);
    }

    public static NoSuchEntityException withId(MemberId id) {
        return new NoSuchEntityException(String.format("No Member found with ID %d.", id.getValue()));
    }

    public static NoSuchEntityException withId(ProjectId id) {
        return new NoSuchEntityException(String.format("No Project found with ID %d.", id.getValue()));
    }
}
