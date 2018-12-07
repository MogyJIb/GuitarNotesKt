package by.mogyjib.guitarnotes.base.view

import android.widget.Toast
import androidx.fragment.app.Fragment
import by.mogyjib.guitarnotes.utils.findNavController

abstract class BaseFragment: Fragment(), BaseContract.View {
    protected open val presenter: BaseContract.Presenter? = null

    override fun router() = view!!.findNavController()

    override fun context() = context
            ?: throw NullPointerException("Class ${this.javaClass.simpleName} context is null")

    override fun toast(message: Int)
            = Toast.makeText(context, message, Toast.LENGTH_LONG).show()

    override fun onResume() {
        super.onResume()
        presenter?.bind(this)
    }

    override fun onPause() {
        presenter?.unbind()
        super.onPause()
    }
}