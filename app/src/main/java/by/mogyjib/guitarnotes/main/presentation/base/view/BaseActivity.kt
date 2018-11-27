package by.mogyjib.guitarnotes.main.presentation.base.view

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(), BaseContract.View {
    override fun context() = this
}