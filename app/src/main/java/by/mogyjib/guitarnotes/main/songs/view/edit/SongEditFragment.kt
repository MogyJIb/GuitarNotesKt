package by.mogyjib.guitarnotes.main.songs.view.edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.mogyjib.guitarnotes.R
import by.mogyjib.guitarnotes.base.view.BaseFragment
import kotlinx.android.synthetic.main.fragment_song_edit.*
import org.koin.android.ext.android.inject

class SongEditFragment : BaseFragment(), SongEditContract.View {
    override val presenter: SongEditPresenter by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_song_edit, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottom_app_bar.inflateMenu(R.menu.song_edit_bottom_menu)
        back_button.hide()
    }

    override fun showBackButton() = back_button?.show()
}