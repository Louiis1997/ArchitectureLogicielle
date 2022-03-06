package fr.esgi.projet.use_cases.closeProject.exposition;

import fr.esgi.projet.use_cases.closeProject.domain.Job;

import java.util.ArrayList;

public class JobsResponse {
    public ArrayList<Job> jobs;

    public JobsResponse(ArrayList<Job> jobs) {
        this.jobs = jobs;
    }

    @Override
    public String toString() {
        return "JobsDTO{" +
                "Jobs{" + jobs +
                '}';
    }
}
