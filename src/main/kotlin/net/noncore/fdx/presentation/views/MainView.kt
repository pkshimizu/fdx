package net.noncore.fdx.presentation.views

import tornadofx.*

class MainView : View("Main View") {

    override val root = borderpane {
        center = label {
            text = "fdx ver 1.0.0"
            maxHeight = 16.0
        }
        right = label { text = "2021-07-23 17:47"}
        prefHeight = 16.0
        maxHeight = 16.0
    }
}
