package by.mogyjib.guitarnotes.presentation.main.songs.view.list

import by.mogyjib.guitarnotes.presentation.base.view.BasePresenter
import by.mogyjib.guitarnotes.data.models.Song
import by.mogyjib.guitarnotes.data.repository.IRepository
import by.mogyjib.guitarnotes.presentation.utils.async
import io.reactivex.Observable
import io.reactivex.rxkotlin.plusAssign
import java.util.concurrent.TimeUnit


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

        disposables += Observable.fromCallable {  }
                .delay(700, TimeUnit.MILLISECONDS)
                .async()
                .subscribe { view?.showAddButton() }
    }

    override fun onSongItemClicked(song: Song) {
        view?.hideAddButton()
        view?.navigateToEditSong()
    }
}