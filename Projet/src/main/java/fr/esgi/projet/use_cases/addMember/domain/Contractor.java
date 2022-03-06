package fr.esgi.projet.use_cases.addMember.domain;

import java.util.ArrayList;

public class Contractor implements Role{
    private ArrayList<Project> projects;

    public Contractor() {
        this.projects = new ArrayList<Project>();
    }

    public void addProject(Project project) {
        this.projects.add(project);
    }

    public void employ(Project project, Tradesman tradesman) {
        project.addTradesman(tradesman);
    }

    public void fire(Project project, Tradesman tradesman){
        project.fireTradesman(tradesman);
    }

    @Override
    public String toString(){
        return "Contractor{ Projects = '" + projects + "'}";
    }
}
