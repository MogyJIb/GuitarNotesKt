package by.mogyjib.guitarnotes.main.presentation.songs.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.mogyjib.guitarnotes.R
import by.mogyjib.guitarnotes.main.data.models.Song
import by.mogyjib.guitarnotes.main.presentation.songs.BaseSongFragment
import by.mogyjib.guitarnotes.utils.disable
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_song_detail.*
import org.koin.android.ext.android.inject


class SongDetailFragment : BaseSongFragment(), SongDetailContract.View {
    override val presenter: SongDetailContract.Presenter by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_song_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* Bind song data to view */
        (arguments?.get("SONG") as? Song)?.run {
            name_edit_text.setText(name)
            author_edit_text.setText(author)
            text_edit_text.setText(text)
        }

        /* Init bottom app bar with button */
        bottomBarButton().run {
            hide(object : FloatingActionButton.OnVisibilityChangedListener() {
                override fun onHidden(fab: FloatingActionButton?) {
                    bottomBar().replaceMenu(R.menu.song_detail_bottom_menu)
                    bottomBar().fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END

                    setImageResource(R.drawable.outline_arrow_back_ios_white_24)
                    bottomBarButton().setOnClickListener { presenter.onBackButtonClicked() }

                    show()
                }
            })
        }

        name_edit_text.disable()
        author_edit_text.disable()
        text_edit_text.disable()

        /* Init on menu item click listener */
        bottomBar().setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_delete -> {
                    val songId = (arguments?.get("SONG") as? Song)?.uid
                    songId?.run { presenter.onDeleteButtonClicked(this) }
                    true
                }
                R.id.action_edit -> {
                    val song = (arguments?.get("SONG") as? Song)
                    song?.run { presenter.onEditButtonClicked(this) }
                    true
                }
                else -> false
            }
        }
    }
}