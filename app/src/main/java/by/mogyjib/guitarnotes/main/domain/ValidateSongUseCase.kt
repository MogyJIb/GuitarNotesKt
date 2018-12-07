package by.mogyjib.guitarnotes.main.domain

import by.mogyjib.guitarnotes.main.data.models.Song

class ValidateSongUseCase {
    fun validateName(name: String) = !name.isEmpty()
    fun validateAuthor(author: String) = !author.isEmpty()
    fun validateText(text: String) = !text.isEmpty()

    fun validateSong(song: Song) = validateName(song.name)
            && validateAuthor(song.author)
            && validateText(song.text)
}