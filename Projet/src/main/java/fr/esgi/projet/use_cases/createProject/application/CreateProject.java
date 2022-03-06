package fr.esgi.projet.use_cases.createProject.application;

import fr.esgi.projet.kernel.Command;
import fr.esgi.projet.use_cases.createProject.domain.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class CreateProject implements Command {
    public final Contractor contractor;
    public ArrayList<Tradesman> tradesmen;
    public ArrayList<Job> jobs;
    public ArrayList<Skill> skills;
    public String localisation;
    public HashMap<Job,Integer> billRate;
    public int duration;

    public CreateProject(Contractor contractor){
        this.contractor = Objects.requireNonNull(contractor);
        this.tradesmen = new ArrayList<>();
        this.jobs = new ArrayList<>();
        this.skills = new ArrayList<>();
        this.localisation = "";
        this.billRate = new HashMap<>();
        this.duration = 0;
    }

    /*public CreateProject(Contractor contractor, ArrayList<Tradesman> tradesmen, ArrayList<Job> jobs, ArrayList<Skill> skills, String localisation, HashMap<Job,Integer> billRate, int duration) {
        this.contractor = Objects.requireNonNull(contractor);
        this.tradesmen = tradesmen;
        this.jobs = Objects.requireNonNull(jobs);
        this.skills = Objects.requireNonNull(skills);
        this.localisation = Objects.requireNonNull(localisation);
        this.billRate = Objects.requireNonNull(billRate);
        this.duration = Objects.requireNonNull(duration);
    }*/
}
