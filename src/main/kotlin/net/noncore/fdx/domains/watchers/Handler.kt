package net.noncore.fdx.domains.watchers

interface Handler<E> {
    fun handle(event: E)
}