package by.mogyjib.guitarnotes.base.view

import android.content.Context

object BaseContract {

    /**
     * Base presenter
     */
    interface Presenter<V : View> {

        fun init() {}
        fun onViewCreated(view: V)
        fun onDestroyView() {}
    }

    /**
     * Base view
     */
    interface View {

        fun context(): Context
        fun withProgress(action: () -> Unit) { action() }
        fun handleError(error: Throwable) {
            println("${this.javaClass.simpleName}\n${error.message}")
            error.printStackTrace()
        }
    }
}