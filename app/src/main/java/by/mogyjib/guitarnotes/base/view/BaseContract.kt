package by.mogyjib.guitarnotes.base.view

import android.content.Context
import android.util.Log
import androidx.annotation.StringRes
import androidx.navigation.NavController

interface BaseContract {
    /**
     * Base presenter
     */
    interface Presenter {
        fun init() {}
        fun bind(view: Any)
        fun unbind() {}
        fun handleError(error: Throwable) {
            println("${this.javaClass.simpleName}\n${error.message}")
            Log.e(this::class.java.simpleName, error.message, error)
            error.printStackTrace()
        }
    }

    /**
     * Base view
     */
    interface View : Router {
        fun context(): Context
    }

    /**
     * Base router
     */
    interface Router {
        fun router(): NavController
    }
}