package by.mogyjib.guitarnotes.base.view

import androidx.fragment.app.Fragment

abstract class BaseFragment: Fragment(), BaseContract.View {
    protected abstract val presenter: BaseContract.Presenter

    override fun router() =
                if (activity is BaseActivity)
                    (activity as BaseActivity).router()
                else
                    throw IllegalStateException(
                            "Can't set BaseFragment to ${activity?.javaClass?.simpleName}." +
                                    " Use only with BaseActivity instance."
                    )

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