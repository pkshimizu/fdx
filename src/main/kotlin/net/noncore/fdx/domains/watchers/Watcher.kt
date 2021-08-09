package net.noncore.fdx.domains.watchers

interface Watcher<E> {
    fun add(handler: Handler<E>)
}
