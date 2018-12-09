package by.mogyjib.guitarnotes.main.domain

import by.mogyjib.guitarnotes.main.data.models.Song
import by.mogyjib.guitarnotes.main.data.repository.IRepository
import by.mogyjib.guitarnotes.utils.extentions.async

class DeleteSongUseCase(
        private val repository: IRepository
) {
    fun deleteSong(songId: String) = repository.songs().delete(songId)
    fun deleteSongAsync(songId: String) = deleteSong(songId).async()

    fun deleteSong(song: Song) = repository.songs().delete(song)
    fun deleteSongAsync(song: Song) = deleteSong(song).async()
}