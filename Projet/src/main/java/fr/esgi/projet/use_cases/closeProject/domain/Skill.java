package fr.esgi.projet.use_cases.closeProject.domain;

public class Skill {
    private final String skill;

    public Skill(String skill) {
        this.skill = skill;
    }

    public String getSkill() {
        return skill;
    }

    @Override
    public String toString(){
        return "Skill{'" + skill + "'}";
    }
}
