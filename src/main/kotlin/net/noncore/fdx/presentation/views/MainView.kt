package net.noncore.fdx.presentation.views

import net.noncore.fdx.domain.use_cases.SampleUseCase
import tornadofx.*

class MainView : View("Main View") {
    private val sampleUseCase: SampleUseCase by di()

    override val root = vbox {
        label { text = sampleUseCase.execute("Taro")}
    }
}
