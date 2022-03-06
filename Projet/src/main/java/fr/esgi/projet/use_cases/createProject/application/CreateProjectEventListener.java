package fr.esgi.projet.use_cases.createProject.application;

import fr.esgi.projet.kernel.EventListener;

public class CreateProjectEventListener implements EventListener<CreateProjectEvent> {
    @Override
    public void listenTo(CreateProjectEvent event) {
        System.out.println("listening CreateProjectEvent.");
    }
}
