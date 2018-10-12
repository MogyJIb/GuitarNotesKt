package by.mogyjib.guitarnotes.base.view

import androidx.fragment.app.Fragment
import by.mogyjib.guitarnotes.utils.progress.ProgressDialogFragment

abstract class BaseFragment : Fragment(), BaseContract.View {

    override fun context() = context
            ?: throw NullPointerException("Class ${this.javaClass.simpleName} context is null")

}