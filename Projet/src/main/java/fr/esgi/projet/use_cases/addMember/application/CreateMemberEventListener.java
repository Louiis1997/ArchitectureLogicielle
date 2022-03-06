package fr.esgi.projet.use_cases.addMember.application;

import fr.esgi.projet.kernel.EventListener;

public class CreateMemberEventListener implements EventListener<CreateMemberEvent> {
    @Override
    public void listenTo(CreateMemberEvent event) {
        System.out.println("listening CreateMemberEvent.");
    }
}