package by.mogyjib.guitarnotes.utils

import android.util.Log
import android.view.View
import androidx.annotation.StringRes
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigator
import com.google.android.material.textfield.TextInputLayout
import java.util.*


fun IntRange.rand() = Random().nextInt((endInclusive + 1) - start) + start

fun View.findNavController() = Navigation.findNavController(this)

fun fragmentNavigatorExtras(vararg sharedElements: Pair<View, String>) =
        FragmentNavigator.Extras.Builder().apply {
            sharedElements.forEach { (view, name) ->
                addSharedElement(view, name)
            }
        }.build()

fun View.hide() = let { visibility = View.GONE }
fun View.show() = let { visibility = View.VISIBLE }
fun View.isVisible() = visibility == View.VISIBLE

fun View.enable() = let { isEnabled = true }
fun View.disable() = let { isEnabled = false }

fun TextInputLayout.showError(@StringRes errorRes: Int) = run { error = context.getString(errorRes) }
fun TextInputLayout.hideError() = run { isErrorEnabled = false }

fun <T> Class<T>.log(message: String) = Log.d(simpleName, message)