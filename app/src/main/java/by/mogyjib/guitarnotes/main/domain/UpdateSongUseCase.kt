package by.mogyjib.guitarnotes.main.domain

import by.mogyjib.guitarnotes.main.data.models.Song
import by.mogyjib.guitarnotes.main.data.repository.IRepository
import by.mogyjib.guitarnotes.utils.async

class UpdateSongUseCase(
        private val repository: IRepository
) {
    fun updateSong(song: Song, songId: String? = null) =
        songId?.let {
            repository.songs().update(song.copy(uid = songId))

        } ?: repository.songs().add(song)

    fun updateSongAsync(song: Song, songId: String? = null) = updateSong(song, songId).async()
}