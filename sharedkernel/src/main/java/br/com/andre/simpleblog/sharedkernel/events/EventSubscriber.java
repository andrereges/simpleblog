package br.com.andre.simpleblog.sharedkernel.events;

public interface EventSubscriber {
    <E extends ApplicationEvent> void onEvent(E event);
}
