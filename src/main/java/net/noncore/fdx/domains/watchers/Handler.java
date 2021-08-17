package net.noncore.fdx.domains.watchers;

public interface Handler<E> {
    void handle(E event);
}
