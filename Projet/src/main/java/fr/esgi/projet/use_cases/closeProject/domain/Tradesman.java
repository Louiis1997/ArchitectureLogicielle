package fr.esgi.projet.use_cases.closeProject.domain;

import java.util.ArrayList;

public class Tradesman implements Role {
    private Job job;
    private ArrayList<Skill> skill;
    private String geographicalArea;
    private int billRate;
    private ArrayList<Skill> aptitudeCertificates;

    public Tradesman(Job job, String area, int billRate) {
        this.job = job;
        this.skill = new ArrayList<>();
        this.geographicalArea = area;
        this.billRate = billRate;
        this.aptitudeCertificates = new ArrayList<>();
    }

    public void addSkill(Skill skill){
        this.skill.add(skill);
    }

    public void addCertificats(Skill skill){
        this.aptitudeCertificates.add(skill);
    }

    public Job getJob() {
        return job;
    }

    public String getGeographicalArea() {
        return geographicalArea;
    }

    public int getBillRate() {
        return billRate;
    }

    public ArrayList<Skill> getSkill() {
        return skill;
    }

    public ArrayList<Skill> getAptitudeCertificates() {
        return aptitudeCertificates;
    }

    @Override
    public String toString(){
        return "Tradesman{ Skill='" + skill +
                "',Geographical Area='" + geographicalArea +
                "', Daily Tax='" + billRate + "'}";
    }
}
