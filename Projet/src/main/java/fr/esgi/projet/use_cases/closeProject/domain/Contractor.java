package fr.esgi.projet.use_cases.closeProject.domain;

import java.util.ArrayList;

public class Contractor implements Role {
    private ArrayList<Project> projects;

    public Contractor() {
        this.projects = new ArrayList<>();
    }

    public void addProject(Project project) {
        this.projects.add(project);
    }

    public void removeProject(Project project)
    {
        this.projects.remove(project);
    }

    public void employ(Project project, Tradesman tradesman) {
        project.addTradesman(tradesman);
    }

    public void fire(Project project, Tradesman tradesman){
        project.fireTradesman(tradesman);
    }
}
