package net.noncore.fdx.views

import javafx.scene.layout.AnchorPane
import tornadofx.*

class MainView : View("Main View") {
    override val root: AnchorPane by fxml("/MainView.fxml")

    override fun onCreate() {
        super.onCreate()
    }

    override fun onBeforeShow() {
        super.onBeforeShow()
        root.children.add(FilesBoard().root)
    }
}
