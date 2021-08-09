package net.noncore.fdx.domains.services

interface Service<P, R> {
    fun execute(params: P): R
}