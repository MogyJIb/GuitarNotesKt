package by.mogyjib.guitarnotes.main.presentation.songs.detail

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import by.mogyjib.guitarnotes.R
import by.mogyjib.guitarnotes.main.data.models.Song
import by.mogyjib.guitarnotes.main.presentation.InfoDialog
import by.mogyjib.guitarnotes.main.presentation.songs.BaseSongFragment
import by.mogyjib.guitarnotes.utils.extentions.disable
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputLayout
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

        disableInputField(name_edit_text, name_input_layout)
        disableInputField(author_edit_text, author_input_layout)
        disableInputField(text_edit_text, text_input_layout)

        /* Init on menu item click listener */
        bottomBar().setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_delete -> deleteButtonClicked()
                R.id.action_edit -> {
                    val song = (arguments?.get("SONG") as? Song)
                    song?.run { presenter.onEditButtonClicked(this) }
                    true
                }
                else -> false
            }
        }
    }

    private fun disableInputField(editText: EditText, textInputLayout: TextInputLayout) {
        editText.disable()
        textInputLayout.isHelperTextEnabled = false
        textInputLayout.isCounterEnabled = false
    }

    private fun deleteButtonClicked(): Boolean {
        val songId = (arguments?.get("SONG") as? Song)?.uid
        songId ?: return true

        InfoDialog.newInstance(
                title = getString(R.string.dialog_delete_song_title),
                message = getString(R.string.dialog_delete_song_message),
                leftButtonCaption = getString(R.string.cancel),
                rightButtonCaption = getString(R.string.resume)
        ).apply {
            rightButtonListener = DialogInterface.OnClickListener { _, _ ->
                presenter.onDeleteButtonClicked(songId)
            }
        }.show(fragmentManager, InfoDialog::class.java.simpleName)
        return true
    }
}