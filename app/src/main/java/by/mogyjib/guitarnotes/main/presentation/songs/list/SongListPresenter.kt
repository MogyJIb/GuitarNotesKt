package by.mogyjib.guitarnotes.main.presentation.songs.list

import androidx.core.os.bundleOf
import by.mogyjib.guitarnotes.R
import by.mogyjib.guitarnotes.main.presentation.base.view.BasePresenter
import by.mogyjib.guitarnotes.main.data.models.Song
import by.mogyjib.guitarnotes.main.data.repository.IRepository
import by.mogyjib.guitarnotes.utils.async
import io.reactivex.Observable
import io.reactivex.rxkotlin.plusAssign


class SongListPresenter(
        private val repository: IRepository
) : BasePresenter<SongListContract.View>(), SongListContract.Presenter {
    override fun init() {
        disposables += repository.songs().getAll()
                .async()
                .doOnError {
                    handleError(it)
                    Observable.just(emptyList<Song>())
                }
                .subscribe { view?.updateSongs(it) }
    }

    override fun onSongItemClicked(song: Song)
            = view?.router()?.navigate(
                    R.id.action_songlist_to_song_detail,
                    bundleOf("SONG" to song)
            ) ?: Unit

    override fun onAddSongClicked()
            = view?.router()?.navigate(R.id.action_songlist_to_song_detail) ?: Unit
}