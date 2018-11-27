package by.mogyjib.guitarnotes.main.presentation.songs

import android.os.Bundle
import by.mogyjib.guitarnotes.main.presentation.base.view.BaseFragment

abstract class BaseSongFragment : BaseFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        if (activity !is SongActivity) throw IllegalStateException("BaseSongFragment should be used only for SongActivity")
        super.onCreate(savedInstanceState)
    }

    override fun onDestroyView() {
        (activity as SongActivity).toggleBottomBarButton(true)
        super.onDestroyView()
    }

    fun bottomBar() = (activity as SongActivity).bottomBar()
    fun bottomBarButton() = (activity as SongActivity).bottomBarButton()
}