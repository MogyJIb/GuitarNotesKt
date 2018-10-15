package by.mogyjib.guitarnotes.base.view

import android.content.Context
import androidx.navigation.NavController

object BaseContract {
    /**
     * Base presenter
     */
    interface Presenter {
        fun init() {}
        fun bind(view: Any)
        fun unbind() {}
    }

    /**
     * Base view
     */
    interface View : Router {
        fun context(): Context
        fun handleError(error: Throwable) {
            println("${this.javaClass.simpleName}\n${error.message}")
            error.printStackTrace()
        }
    }

    /**
     * Base router
     */
    interface Router {
        fun router(): NavController
    }
}