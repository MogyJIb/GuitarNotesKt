package by.mogyjib.guitarnotes.main.domain

import by.mogyjib.guitarnotes.main.data.models.Song
import by.mogyjib.guitarnotes.main.data.repository.IRepository
import by.mogyjib.guitarnotes.utils.extentions.async
import io.reactivex.Observable

class GetSongsUseCase(
        private val repository: IRepository
) {
    fun getSongsFilteredByName(): Observable<List<Song>>
            = repository.songs().getAll()
                    .flatMap { list ->
                        Observable.fromIterable(list)
                                .sorted(compareBy { song -> song.name })
                                .toList()
                                .toObservable()
                    }
                    .onErrorReturn { emptyList() }

    fun getSongsFilteredByNameAsync(): Observable<List<Song>> = getSongsFilteredByName().async()
}