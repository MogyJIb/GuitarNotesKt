package by.mogyjib.guitarnotes.main.presentation.songs.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.mogyjib.guitarnotes.R
import by.mogyjib.guitarnotes.main.data.models.Song
import by.mogyjib.guitarnotes.main.presentation.songs.BaseSongFragment
import by.mogyjib.guitarnotes.utils.disable
import by.mogyjib.guitarnotes.utils.enable
import kotlinx.android.synthetic.main.fragment_song_detail.*
import org.koin.android.ext.android.inject


class SongDetailFragment : BaseSongFragment(), SongDetailContract.View {
    override val presenter: SongDetailContract.Presenter by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_song_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* Init bottom app bar with button */
        bottomBar().replaceMenu(R.menu.song_detail_bottom_menu)
        bottomBarButton().setImageResource(R.drawable.outline_arrow_back_ios_white_24)
        bottomBarButton().setOnClickListener { router().navigateUp() }

        /* Bind song data to view */
        (arguments?.get("SONG") as? Song)?.run {
            name_edit_text.setText(name)
            author_edit_text.setText(author)
            text_edit_text.setText(text)
        }

        name_input_layout.disable()
        author_input_layout.disable()
        text_input_layout.disable()
    }
}