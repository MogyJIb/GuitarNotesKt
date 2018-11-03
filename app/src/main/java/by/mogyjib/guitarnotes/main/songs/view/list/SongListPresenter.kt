package by.mogyjib.guitarnotes.main.songs.view.list

import by.mogyjib.guitarnotes.base.view.BasePresenter
import by.mogyjib.guitarnotes.data.models.Song
import by.mogyjib.guitarnotes.data.repository.IRepository
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
}