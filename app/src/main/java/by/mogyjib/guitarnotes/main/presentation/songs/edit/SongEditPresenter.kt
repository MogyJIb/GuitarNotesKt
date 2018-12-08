package by.mogyjib.guitarnotes.main.presentation.songs.edit

import by.mogyjib.guitarnotes.R
import by.mogyjib.guitarnotes.main.data.models.Song
import by.mogyjib.guitarnotes.base.view.BasePresenter
import by.mogyjib.guitarnotes.main.domain.DeleteSongUseCase
import by.mogyjib.guitarnotes.main.domain.UpdateSongUseCase
import by.mogyjib.guitarnotes.main.domain.ValidateSongUseCase
import by.mogyjib.guitarnotes.utils.toast
import io.reactivex.rxkotlin.plusAssign

class SongEditPresenter(
        private val validateSongUseCase: ValidateSongUseCase,
        private val updateSongUseCase: UpdateSongUseCase,
        private val deleteSongUseCase: DeleteSongUseCase
) : BasePresenter<SongEditContract.View>(), SongEditContract.Presenter {
    override fun onDeleteButtonClicked(songId: String?) {
        songId?.let {
            disposables += deleteSongUseCase.deleteSongAsync(songId)
                    .subscribe({
                        view?.run {
                            context().toast(R.string.delete_song_success)
                            router().navigateUp()
                        }
                    }, this::handleError)
        }
    }

    override fun onSaveButtonClicked(song: Song, songId: String?) {
        if (validateSong(song))
            disposables += updateSongUseCase.updateSongAsync(song, songId)
                    .subscribe({
                        view?.run {
                            context().toast(R.string.save_song_success)
                            router().navigateUp()
                        }
                    }, this::handleError)
    }

    override fun onBackButtonClicked() { view?.router()?.navigateUp() }

    private fun validateSong(song: Song) = when {
        !validateSongUseCase.validateName(song.name) -> {
            view?.showNameError(R.string.invalid_song_name_error)
            false
        }
        !validateSongUseCase.validateAuthor(song.author) -> {
            view?.showAuthorError(R.string.invalid_song_author_error)
            false
        }
        !validateSongUseCase.validateText(song.text) -> {
            view?.showTextError(R.string.invalid_song_text_error)
            false
        }
        else -> true
    }
}