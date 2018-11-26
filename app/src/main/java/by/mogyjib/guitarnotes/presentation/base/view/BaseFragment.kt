package by.mogyjib.guitarnotes.presentation.base.view

import androidx.fragment.app.Fragment
import by.mogyjib.guitarnotes.presentation.utils.findNavController

abstract class BaseFragment: Fragment(), BaseContract.View {
    protected abstract val presenter: BaseContract.Presenter

    override fun router() = view!!.findNavController()

    override fun context() = context
            ?: throw NullPointerException("Class ${this.javaClass.simpleName} context is null")

    override fun onResume() {
        super.onResume()
        presenter.bind(this)
    }

    override fun onPause() {
        presenter.unbind()
        super.onPause()
    }
}