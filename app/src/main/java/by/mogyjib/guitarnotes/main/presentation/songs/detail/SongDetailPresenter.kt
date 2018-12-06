package by.mogyjib.guitarnotes.main.presentation.songs.detail

import by.mogyjib.guitarnotes.R
import by.mogyjib.guitarnotes.base.view.BasePresenter
import by.mogyjib.guitarnotes.main.domain.DeleteSongUseCase
import io.reactivex.rxkotlin.plusAssign

class SongDetailPresenter(
        private val deleteSongUseCase: DeleteSongUseCase
) : BasePresenter<SongDetailContract.View>(), SongDetailContract.Presenter {
    override fun onDeleteButtonClicked(songId: String) {
        disposables += deleteSongUseCase.deleteSongAsync(songId)
                .subscribe({
                    view?.toast(R.string.delete_song_success)
                    view?.router()?.navigateUp()
                }, this::handleError)
    }

    override fun onBackButtonClicked() { view?.router()?.navigateUp() }
}