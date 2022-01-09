package fr.esgi.cc2.kernel;

public interface EventDispatcher<E extends Event> {
    void dispatch(E event);
}

