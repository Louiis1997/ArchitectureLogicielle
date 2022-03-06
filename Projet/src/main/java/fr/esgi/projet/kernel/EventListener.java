package fr.esgi.projet.kernel;

public interface EventListener<E extends Event> {
    void listenTo(E event);
}