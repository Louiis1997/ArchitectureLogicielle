package fr.esgi.projet.use_cases.addMember.domain;

import java.util.ArrayList;

public class Project {
    private final Contractor contractor;
    private ArrayList<Tradesman> tradesmen;
    private ArrayList<Job> jobs;
    private ArrayList<Skill> skills;
    private final String localisation;
    private int billRate;
    private final int duration;

    public Project(Contractor contractor, String localisation, int billRate, int duration){
        this.contractor = contractor;
        this.tradesmen = new ArrayList<>();
        this.jobs = new ArrayList<>();
        this.skills = new ArrayList<>();
        this.localisation = localisation;
        this.billRate= billRate;
        this.duration = duration;
    }

    public void addTradesman(Tradesman tradesman){
        this.tradesmen.add(tradesman);
    }

    public void fireTradesman(Tradesman tradesman){
        this.tradesmen.remove(tradesman);
    }

    public void addJob(Job job){
        this.jobs.add(job);
    }

    public void addSkill(Skill skill){
        this.skills.add(skill);
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

    public int getBillRate() {
        return billRate;
    }

    public int getDuration() {
        return duration;
    }
}
