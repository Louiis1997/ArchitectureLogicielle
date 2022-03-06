package fr.esgi.projet.kernel;

public interface EventDispatcher<E extends Event> {
    void dispatch(E event);
}

