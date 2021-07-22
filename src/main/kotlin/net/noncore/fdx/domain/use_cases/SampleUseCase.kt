package net.noncore.fdx.domain.use_cases

import org.springframework.stereotype.Component

interface SampleUseCase : UseCase<String, String>

@Component
class SampleUseCaseImpl : SampleUseCase {
    override fun execute(params: String): String {
        return "$params hello"
    }
}
