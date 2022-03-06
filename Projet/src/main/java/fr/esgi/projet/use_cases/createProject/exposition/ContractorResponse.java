package fr.esgi.projet.use_cases.createProject.exposition;

import fr.esgi.projet.use_cases.createProject.domain.Contractor;

public class ContractorResponse {
    public Contractor contractor;

    public ContractorResponse(Contractor contractor) {
        this.contractor = contractor;
    }

    @Override
    public String toString() {
        return "ContractorDTO{" +
                "Contractor{" + contractor +
                '}';
    }
}
