package net.noncore.fdx.domains.watchers;

public interface Watcher<E> {
    void add(Handler<E> handler);
    void start();
    void destroy();
}
