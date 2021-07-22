package net.noncore.fdx.domain.use_cases

interface UseCase<P, R> {
    fun execute(params: P): R
}