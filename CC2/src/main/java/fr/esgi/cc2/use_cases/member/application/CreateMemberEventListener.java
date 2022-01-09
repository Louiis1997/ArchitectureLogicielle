package fr.esgi.cc2.use_cases.member.application;

import fr.esgi.cc2.kernel.EventListener;

public class CreateMemberEventListener implements EventListener<CreateMemberEvent> {
    @Override
    public void listenTo(CreateMemberEvent event) {
        System.out.println("listening CreateMemberEvent.");
    }
}