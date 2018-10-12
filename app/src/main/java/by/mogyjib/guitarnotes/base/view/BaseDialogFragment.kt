package by.mogyjib.guitarnotes.base.view

import androidx.fragment.app.DialogFragment
import by.mogyjib.guitarnotes.utils.progress.ProgressDialogFragment

abstract class BaseDialogFragment : DialogFragment(), BaseContract.View {

    override fun context() = context
            ?: throw NullPointerException("Class ${this.javaClass.simpleName} context is null")

}