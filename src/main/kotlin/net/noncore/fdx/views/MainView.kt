package net.noncore.fdx.views

import javafx.scene.layout.AnchorPane
import tornadofx.*

class MainView : View("Main View") {
    override val root: AnchorPane by fxml("/MainView.fxml")
}