package fr.esgi.projet.use_cases.createProject.exposition;

import fr.esgi.projet.use_cases.createProject.domain.Skill;

import java.util.ArrayList;

public class SkillsResponse {
    public ArrayList<Skill> skills;

    public SkillsResponse(ArrayList<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "SkillsDTO{" +
                "Skills{" + skills +
                '}';
    }
}
