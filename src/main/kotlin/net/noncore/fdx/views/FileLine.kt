package net.noncore.fdx.views

import javafx.scene.control.Label
import javafx.scene.layout.AnchorPane
import tornadofx.*

class FileLine : View("File Line") {
    val name: Label by fxid()
    val size: Label by fxid()
    val date: Label by fxid()

    override val root: AnchorPane by fxml("/FileLine.fxml")
}
