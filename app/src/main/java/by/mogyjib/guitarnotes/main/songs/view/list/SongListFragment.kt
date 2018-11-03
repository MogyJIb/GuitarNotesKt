package by.mogyjib.guitarnotes.main.songs.view.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import by.mogyjib.guitarnotes.R
import by.mogyjib.guitarnotes.base.view.BaseFragment
import by.mogyjib.guitarnotes.data.models.Song
import by.mogyjib.guitarnotes.main.songs.SongsAdapter
import kotlinx.android.synthetic.main.fragment_songlist.*
import org.koin.android.ext.android.inject
import androidx.recyclerview.widget.DividerItemDecoration


class SongListFragment : BaseFragment(), SongListContract.View {
    override val presenter: SongListPresenter by inject()

    private lateinit var songsAdapter: SongsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_songlist, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottom_app_bar.inflateMenu(R.menu.songlist_bottom_menu)

        songsAdapter = SongsAdapter()

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