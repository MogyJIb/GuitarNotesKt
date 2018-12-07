package by.mogyjib.guitarnotes.main.presentation.songs.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import by.mogyjib.guitarnotes.R
import by.mogyjib.guitarnotes.main.data.models.Song
import by.mogyjib.guitarnotes.main.presentation.songs.SongsAdapter
import kotlinx.android.synthetic.main.fragment_songlist.*
import org.koin.android.ext.android.inject
import androidx.recyclerview.widget.DividerItemDecoration
import by.mogyjib.guitarnotes.main.presentation.songs.BaseSongFragment
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton


class SongListFragment : BaseSongFragment(), SongListContract.View {
    override val presenter: SongListContract.Presenter by inject()

    private lateinit var songsAdapter: SongsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_songlist, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* Init bottom app bar with button */
        bottomBarButton().run {
            hide(object : FloatingActionButton.OnVisibilityChangedListener() {
                override fun onHidden(fab: FloatingActionButton?) {
                    bottomBar().replaceMenu(R.menu.songlist_bottom_menu)
                    bottomBar().fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER

                    setImageResource(R.drawable.outline_add_white_24)
                    setOnClickListener { presenter.onAddSongClicked() }

                    show()
                }
            })
        }

        /* Init adapter and set up recycler view */
        songsAdapter = SongsAdapter()
        songsAdapter.onClickListener = presenter::onSongItemClicked

        songs_recycler_view.apply {
            adapter = songsAdapter

            val dividerItemDecoration = DividerItemDecoration(
                    context, DividerItemDecoration.VERTICAL)
            ContextCompat.getDrawable(context(), R.drawable.list_divider)?.let {
                dividerItemDecoration.setDrawable(it)
            }
            addItemDecoration(dividerItemDecoration)
        }
    }

    override fun updateSongs(songs: List<Song>) = songsAdapter.updateItems(songs)
}