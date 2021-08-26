module br.com.andre.simpleblog.infrastructure {
    requires transitive br.com.andre.simpleblog.sharedkernel;

    provides br.com.andre.simpleblog.sharedkernel.events.EventBus
            with br.com.andre.simpleblog.infrastructure.events.SimpleEventBus;
}