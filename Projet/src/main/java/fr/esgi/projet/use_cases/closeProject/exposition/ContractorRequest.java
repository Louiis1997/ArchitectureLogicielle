package fr.esgi.projet.use_cases.closeProject.exposition;

import fr.esgi.projet.use_cases.closeProject.domain.Contractor;

public class ContractorRequest {
    public Contractor contractor;

    @Override
    public String toString() {
        return "Contractor{'" + contractor + "'}";
    }
}
