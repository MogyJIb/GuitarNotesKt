package by.mogyjib.guitarnotes.presentation.utils

import android.view.View
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigator
import java.util.*


fun IntRange.rand() = Random().nextInt((endInclusive + 1) - start) + start

fun View.findNavController() = Navigation.findNavController(this)

fun FragmentNavigatorExtras(vararg sharedElements: Pair<View, String>) =
        FragmentNavigator.Extras.Builder().apply {
            sharedElements.forEach { (view, name) ->
                addSharedElement(view, name)
            }
        }.build()