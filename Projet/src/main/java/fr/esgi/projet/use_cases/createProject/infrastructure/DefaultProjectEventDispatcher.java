package fr.esgi.projet.use_cases.createProject.infrastructure;

import fr.esgi.projet.kernel.Event;
import fr.esgi.projet.kernel.EventDispatcher;
import fr.esgi.projet.kernel.EventListener;

import java.util.List;
import java.util.Map;

public class DefaultProjectEventDispatcher<E extends Event> implements EventDispatcher<E> {

    private final Map<Class<E>, List<EventListener<E>>> eventListenersMap;

    public DefaultProjectEventDispatcher(Map<Class<E>, List<EventListener<E>>> eventListenersMap) {
        this.eventListenersMap = eventListenersMap;
    }

    @Override
    public void dispatch(E event) {
        final List<EventListener<E>> eventListeners = eventListenersMap.get(event.getClass());
        if (eventListeners != null) {
            eventListeners.forEach(eEventListener -> eEventListener.listenTo(event));
        }
    }
}
