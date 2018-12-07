package by.mogyjib.guitarnotes.main.presentation.songs

import android.os.Bundle
import by.mogyjib.guitarnotes.base.view.BaseFragment
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton

abstract class BaseSongFragment : BaseFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        if (activity !is SongActivity) throw IllegalStateException("BaseSongFragment should be used only for SongActivity")
        bottomBarButton().setOnClickListener(null)
        super.onCreate(savedInstanceState)
    }

    fun bottomBar(): BottomAppBar = (activity as SongActivity).bottomBar()
    fun bottomBarButton(): FloatingActionButton = (activity as SongActivity).bottomBarButton()
}