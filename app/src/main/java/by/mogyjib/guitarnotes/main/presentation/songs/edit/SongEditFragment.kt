package by.mogyjib.guitarnotes.main.presentation.songs.edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.mogyjib.guitarnotes.R
import by.mogyjib.guitarnotes.main.data.models.Song
import by.mogyjib.guitarnotes.main.presentation.songs.BaseSongFragment
import by.mogyjib.guitarnotes.utils.hideError
import by.mogyjib.guitarnotes.utils.showError
import kotlinx.android.synthetic.main.fragment_song_detail.*
import org.koin.android.ext.android.inject


class SongEditFragment : BaseSongFragment(), SongEditContract.View {
    override val presenter: SongEditContract.Presenter by inject()
    private var songId: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_song_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* Bind song data to view */
        (arguments?.get("SONG") as? Song)?.run {
            songId = uid
            name_edit_text.setText(name)
            author_edit_text.setText(author)
            text_edit_text.setText(text)
        }

        /* Init bottom app bar with button */
        bottomBar().replaceMenu(R.menu.song_edit_bottom_menu)
        bottomBarButton().setImageResource(R.drawable.outline_arrow_back_ios_white_24)
        bottomBarButton().setOnClickListener { presenter.onBackButtonClicked() }

        /* Init on menu item click listener */
        bottomBar().setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_delete -> {
                    presenter.onDeleteButtonClicked(songId)
                    true
                }
                R.id.action_save -> {
                    val name = name_edit_text.text.toString()
                    val author = author_edit_text.text.toString()
                    val text = text_edit_text.text.toString()
                    presenter.onSaveButtonClicked(Song(name, author, text), songId)
                    true
                }
                else -> false
            }
        }
    }

    override fun showNameError(errorRes: Int) = name_input_layout.showError(errorRes)
    override fun hideNameError() = name_input_layout.hideError()

    override fun showAuthorError(errorRes: Int) = author_input_layout.showError(errorRes)
    override fun hideAuthorError() = author_input_layout.hideError()

    override fun showTextError(errorRes: Int) = text_input_layout.showError(errorRes)
    override fun hideTextError() = text_input_layout.hideError()
}