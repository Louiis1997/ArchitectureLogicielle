package fr.esgi.projet.use_cases.closeProject.exposition;

import fr.esgi.projet.use_cases.closeProject.domain.Skill;

import java.util.ArrayList;

public class SkillsRequest {
    public ArrayList<Skill> skills;

    @Override
    public String toString() {
        return "Skills{'" + skills + "'}";
    }
}
