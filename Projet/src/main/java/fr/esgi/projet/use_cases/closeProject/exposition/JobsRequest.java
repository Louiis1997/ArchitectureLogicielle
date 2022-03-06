package fr.esgi.projet.use_cases.closeProject.exposition;

import fr.esgi.projet.use_cases.closeProject.domain.Job;

import java.util.ArrayList;

public class JobsRequest {
    public ArrayList<Job> jobs;

    @Override
    public String toString() {
        return "Jobs{'" + jobs + "'}";
    }
}
