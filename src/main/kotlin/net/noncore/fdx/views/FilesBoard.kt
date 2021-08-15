package net.noncore.fdx.views

import javafx.scene.layout.GridPane
import javafx.scene.layout.VBox
import tornadofx.*

class FilesBoard : View("Files Board") {
    val left: VBox by fxid()
    val right: VBox by fxid()

    override val root: GridPane by fxml("/FilesBoard.fxml")
}
