package by.mogyjib.guitarnotes.main.presentation.songs

import android.view.View
import android.view.ViewGroup
import by.mogyjib.guitarnotes.base.recycler.BaseRecyclerViewAdapter
import by.mogyjib.guitarnotes.base.recycler.BaseViewHolder
import by.mogyjib.guitarnotes.main.data.models.Song
import android.view.LayoutInflater
import by.mogyjib.guitarnotes.R
import kotlinx.android.synthetic.main.song_list_item.view.*


class SongsAdapter : BaseRecyclerViewAdapter<Song, SongsAdapter.SongsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.song_list_item, parent, false)
        return SongsViewHolder(itemView)
    }

    class SongsViewHolder(itemView: View) : BaseViewHolder<Song>(itemView) {
        private val nameTV = itemView.song_name
        private val authorTV = itemView.song_author

        override fun bindData(song: Song) {
            super.bindData(song)
            nameTV.text = song.name
            authorTV.text = song.author
        }
    }
}