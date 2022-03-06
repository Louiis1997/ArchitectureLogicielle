package fr.esgi.projet.use_cases.createProject.exposition;

import fr.esgi.projet.use_cases.createProject.domain.Skill;

import java.util.ArrayList;

public class SkillsRequest {
    public ArrayList<Skill> skills;

    @Override
    public String toString() {
        return "Skills{'" + skills + "'}";
    }
}
