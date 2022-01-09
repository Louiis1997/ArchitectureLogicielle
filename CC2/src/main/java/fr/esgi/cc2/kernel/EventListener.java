package fr.esgi.cc2.kernel;

public interface EventListener<E extends Event> {
    void listenTo(E event);
}