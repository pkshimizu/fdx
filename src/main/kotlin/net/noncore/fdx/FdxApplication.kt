package net.noncore.fdx

import javafx.application.Application
import net.noncore.fdx.presentation.views.MainView
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ConfigurableApplicationContext
import tornadofx.App
import tornadofx.DIContainer
import tornadofx.FX
import kotlin.reflect.KClass

@SpringBootApplication
class FdxApplication: App(MainView::class) {
    private lateinit var context: ConfigurableApplicationContext //We are going to set application context here

    override fun init() {
        this.context = SpringApplication.run(this.javaClass) //We start the application context and let Spring Boot to initilaize itself
        context.autowireCapableBeanFactory.autowireBean(this) //We ask the context to inject all needed dependencies into the current instence (if needed)

        FX.dicontainer = object : DIContainer { // Here we have to implement an interface for TornadoFX DI support
            override fun <T : Any> getInstance(type: KClass<T>): T = context.getBean(type.java) // We find dependencies directly in Spring's application context
            override fun <T : Any> getInstance(type: KClass<T>, name: String): T = context.getBean(name, type.java)
        }
    }

    override fun stop() { // On stop, we have to stop spring as well
        super.stop()
        context.close()
    }
}

fun main(args: Array<String>) {
    runApplication<FdxApplication>(*args)
    Application.launch(FdxApplication::class.java, *args)
}
