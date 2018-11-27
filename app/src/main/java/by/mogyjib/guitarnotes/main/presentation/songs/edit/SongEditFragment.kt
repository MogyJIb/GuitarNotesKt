package by.mogyjib.guitarnotes.main.presentation.songs.edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.mogyjib.guitarnotes.R
import by.mogyjib.guitarnotes.main.presentation.songs.BaseSongFragment
import org.koin.android.ext.android.inject


class SongEditFragment : BaseSongFragment(), SongEditContract.View {
    override val presenter: SongEditPresenter by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_song_edit, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBottomAppBar()
    }

    private fun initBottomAppBar(): Boolean {
        bottomBar().replaceMenu(R.menu.song_edit_bottom_menu)

        bottomBarButton().setImageResource(R.drawable.outline_arrow_back_ios_white_24)
        bottomBarButton().setOnClickListener { router().navigateUp() }
        return true
    }

    override fun onDestroyView() {
        bottomBarButton().setOnClickListener(null)
        super.onDestroyView()
    }
}