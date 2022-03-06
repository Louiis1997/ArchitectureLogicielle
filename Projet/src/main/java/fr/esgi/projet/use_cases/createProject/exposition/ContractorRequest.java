package fr.esgi.projet.use_cases.createProject.exposition;

import fr.esgi.projet.use_cases.createProject.domain.Contractor;

public class ContractorRequest {
    public Contractor contractor;

    @Override
    public String toString() {
        return "Contractor{'" + contractor + "'}";
    }
}
