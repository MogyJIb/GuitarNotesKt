package by.mogyjib.guitarnotes.base.view

import androidx.fragment.app.DialogFragment
import androidx.navigation.NavController

abstract class BaseDialogFragment : DialogFragment(), BaseContract.View {

    override fun context() = context
            ?: throw NullPointerException("Class ${this.javaClass.simpleName} context is null")

    override fun router() =
            if (activity is BaseActivity)
                (activity as BaseActivity).router()
            else
                throw IllegalStateException(
                        "Can't route BaseFragment in ${activity?.javaClass?.simpleName}." +
                                " Use only with BaseActivity instance."
                )

}