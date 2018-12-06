package by.mogyjib.guitarnotes.main.presentation.songs.edit

import by.mogyjib.guitarnotes.R
import by.mogyjib.guitarnotes.main.data.models.Song
import by.mogyjib.guitarnotes.base.view.BasePresenter
import by.mogyjib.guitarnotes.main.domain.UpdateSongUseCase
import by.mogyjib.guitarnotes.main.domain.ValidateSongUseCase
import io.reactivex.rxkotlin.plusAssign

class SongEditPresenter(
        private val validateSongUseCase: ValidateSongUseCase,
        private val updateSongUseCase: UpdateSongUseCase
) : BasePresenter<SongEditContract.View>(), SongEditContract.Presenter {
    override fun onDeleteButtonClicked(songId: String?) {
    }

    override fun onSaveButtonClicked(song: Song, songId: String?) {
        if (validateSong(song))
            disposables += updateSongUseCase.updateSongAsync(song, songId)
                    .subscribe({ view?.toast(R.string.save_song_success) }, this::handleError)
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