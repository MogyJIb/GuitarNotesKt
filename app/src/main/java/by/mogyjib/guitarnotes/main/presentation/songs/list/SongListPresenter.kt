package by.mogyjib.guitarnotes.main.presentation.songs.list

import androidx.core.os.bundleOf
import by.mogyjib.guitarnotes.R
import by.mogyjib.guitarnotes.base.view.BasePresenter
import by.mogyjib.guitarnotes.main.data.models.Song
import by.mogyjib.guitarnotes.main.domain.GetSongsUseCase
import io.reactivex.rxkotlin.plusAssign


class SongListPresenter(
        private val getSongsUseCase: GetSongsUseCase
) : BasePresenter<SongListContract.View>(), SongListContract.Presenter {
    override fun init() {
        disposables += getSongsUseCase.getSongsFilteredByNameAsync()
                .subscribe({ songs -> view?.updateSongs(songs) }, this::handleError)
    }

    override fun onSongItemClicked(song: Song)
            = view?.router()?.navigate(
                    R.id.action_songlist_to_song_detail,
                    bundleOf("SONG" to song)
            ) ?: Unit

    override fun onAddSongClicked()
            = view?.router()?.navigate(R.id.action_songlist_to_song_edit) ?: Unit
}