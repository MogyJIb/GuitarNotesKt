package by.mogyjib.guitarnotes.base.view

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(), BaseContract.View {

    override fun context() = this

}