package net.noncore.fdx.presentation.views

import tornadofx.*

class MainView : View("Main View") {

    override val root = hbox {
        label { text = "fdx ver 1.0.0"}
        label { text = "2021-07-23 17:47"}
    }
}
