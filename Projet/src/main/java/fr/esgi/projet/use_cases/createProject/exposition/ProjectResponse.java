package fr.esgi.projet.use_cases.createProject.exposition;

import fr.esgi.projet.use_cases.createProject.domain.Job;

import java.util.HashMap;

public class ProjectResponse {
    public String id;
    private ContractorResponse contractor;
    private TradesmenResponse tradesmen;
    private JobsResponse jobs;
    private SkillsResponse skills;
    private String localisation;
    private HashMap<Job,Integer> billRate;
    private int duration;

    public ProjectResponse(String id, ContractorResponse contractor, TradesmenResponse tradesmen, JobsResponse jobs, SkillsResponse skills, String localisation, HashMap<Job,Integer> billRate, int duration) {
        this.id = id;
        this.contractor = contractor;
        this.tradesmen = tradesmen;
        this.jobs = jobs;
        this.skills = skills;
        this.localisation = localisation;
        this.billRate = billRate;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "ProjectId=" + id +
                ", Contractor='" + contractor + '\'' +
                ", Tradesmen='" + tradesmen + '\'' +
                ", Jobs='" + jobs + '\'' +
                ", Skills='" + skills + '\'' +
                ", Location='" + localisation + '\'' +
                ", Bill Rate='" + billRate + '\'' +
                ", Duration='" + duration + '\'' +
                '}';
    }
}
