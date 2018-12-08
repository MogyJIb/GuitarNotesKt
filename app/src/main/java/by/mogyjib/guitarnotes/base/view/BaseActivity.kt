package by.mogyjib.guitarnotes.base.view

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import by.mogyjib.guitarnotes.utils.log

abstract class BaseActivity : AppCompatActivity(), BaseContract.View {
    override fun context() = this
    override fun toast(message: Int)
            = Toast.makeText(this, message, Toast.LENGTH_LONG).show()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        javaClass.log("onCreate")
    }

    override fun onStart() {
        super.onStart()
        javaClass.log("onStart")
    }

    override fun onResume() {
        super.onResume()
        javaClass.log("onResume")
    }

    override fun onPause() {
        super.onPause()
        javaClass.log("onPause")
    }

    override fun onStop() {
        super.onStop()
        javaClass.log("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        javaClass.log("onDestroy")
    }
}