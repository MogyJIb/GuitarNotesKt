package by.mogyjib.guitarnotes.base.view

import androidx.appcompat.app.AppCompatActivity
import by.mogyjib.guitarnotes.utils.progress.ProgressDialogFragment

abstract class BaseActivity : AppCompatActivity(), BaseContract.View {
    override fun context() = this

    override fun withProgress(action: () -> Unit) {
        ProgressDialogFragment.actionWithProgress(
                supportFragmentManager, this.javaClass.simpleName, action)
    }
}