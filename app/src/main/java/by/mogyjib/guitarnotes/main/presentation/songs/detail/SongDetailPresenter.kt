package by.mogyjib.guitarnotes.main.presentation.songs.detail

import androidx.core.os.bundleOf
import by.mogyjib.guitarnotes.R
import by.mogyjib.guitarnotes.base.view.BasePresenter
import by.mogyjib.guitarnotes.main.data.models.Song
import by.mogyjib.guitarnotes.main.domain.DeleteSongUseCase
import io.reactivex.rxkotlin.plusAssign

class SongDetailPresenter(
        private val deleteSongUseCase: DeleteSongUseCase
) : BasePresenter<SongDetailContract.View>(), SongDetailContract.Presenter {
    override fun onEditButtonClicked(song: Song) {
        view?.router()?.navigate(R.id.action_detail_to_song_edit, bundleOf("SONG" to song))

    }

    override fun onDeleteButtonClicked(songId: String) {
        disposables += deleteSongUseCase.deleteSongAsync(songId)
                .subscribe({
                    view?.toast(R.string.delete_song_success)
                    view?.router()?.navigateUp()
                }, this::handleError)
    }

    override fun onBackButtonClicked() { view?.router()?.navigateUp() }
}