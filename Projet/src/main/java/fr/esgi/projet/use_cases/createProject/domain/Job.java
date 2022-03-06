package fr.esgi.projet.use_cases.createProject.domain;

public class Job {
    private final String job;

    public Job(String job) {
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    @Override
    public String toString() {
        return "Job{'" + job + "'}";
    }
}
