package fr.esgi.projet.use_cases.closeProject.domain;

import fr.esgi.projet.kernel.Entity;
import fr.esgi.projet.kernel.NoSuchEntityException;
import fr.esgi.projet.use_cases.createProject.domain.ProjectId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;


public class Project implements Entity<ProjectId> {
    private final fr.esgi.projet.use_cases.createProject.domain.ProjectId id;
    private final Contractor contractor;
    private ArrayList<Tradesman> tradesmen;
    private ArrayList<Job> jobs;
    private ArrayList<Skill> skills;
    private String localisation;
    private HashMap<Job,Integer> billRate;
    private int duration;

    public Project(fr.esgi.projet.use_cases.createProject.domain.ProjectId id, Contractor contractor, ArrayList<Tradesman> tradesmen, ArrayList<Job> jobs, ArrayList<Skill> skills, String localisation, HashMap<Job,Integer> billRate, int duration){
        this.id = Objects.requireNonNull(id);
        this.contractor = Objects.requireNonNull(contractor);
        this.tradesmen = tradesmen;
        this.jobs = Objects.requireNonNull(jobs);
        this.skills = Objects.requireNonNull(skills);
        this.localisation = Objects.requireNonNull(localisation);
        this.billRate= billRate;
        this.duration = duration;
    }

    public void addTradesman(Tradesman tradesman){
        this.tradesmen.add(tradesman);
    }

    public void fireTradesman(Tradesman tradesman){
        this.tradesmen.remove(tradesman);
    }

    public void fireAllTradesmen(){
        this.tradesmen.clear();
    }

    public void addJob(Job job){
        this.jobs.add(job);
    }

    public void removeJob(Job job){
        this.jobs.remove(job);
    }

    public void addSkill(Skill skill){
        this.skills.add(skill);
    }

    public void removeSkill(Skill skill){
        this.skills.remove(skill);
    }

    public void addbillRate(Job job, int billRate){
        this.billRate.put(job,billRate);
    }

    public ProjectId getId() {
        return id;
    }

    @Override
    public ProjectId id() {
        return id;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public ArrayList<Tradesman> getTradesmen() {
        return tradesmen;
    }

    public ArrayList<Job> getJobs() {
        return jobs;
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public String getLocalisation() {
        return localisation;
    }

    public HashMap<Job, Integer> getBillRate() {
        return billRate;
    }

    public int getDuration() {
        return duration;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id) && Objects.equals(contractor, project.contractor) && Objects.equals(jobs, project.jobs) && Objects.equals(skills, project.skills) && Objects.equals(localisation, project.localisation) && Objects.equals(duration, project.duration) && Objects.equals(billRate, project.billRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, contractor, tradesmen, jobs, skills, localisation, billRate, duration);
    }

    @Override
    public String toString() {
        return "Project{" +
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
