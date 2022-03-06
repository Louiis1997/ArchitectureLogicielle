package fr.esgi.projet.use_cases.createProject.exposition;

import fr.esgi.projet.use_cases.createProject.domain.Job;

import java.util.ArrayList;

public class JobsRequest {
    public ArrayList<Job> jobs;

    @Override
    public String toString() {
        return "Jobs{'" + jobs + "'}";
    }
}
