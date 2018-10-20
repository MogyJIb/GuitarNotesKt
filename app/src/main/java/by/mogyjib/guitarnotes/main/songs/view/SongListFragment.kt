package by.mogyjib.guitarnotes.main.songs.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.mogyjib.guitarnotes.R
import by.mogyjib.guitarnotes.base.view.BaseFragment
import kotlinx.android.synthetic.main.fragment_songlist.*


class SongListFragment : BaseFragment(), SongListContract.View {

    override val presenter = SongListPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_songlist, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottom_app_bar.inflateMenu(R.menu.songlist_bottom_menu)
    }
}