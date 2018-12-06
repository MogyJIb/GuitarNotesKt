package by.mogyjib.guitarnotes.base.view

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(), BaseContract.View {
    override fun context() = this
    override fun toast(message: Int)
            = Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}