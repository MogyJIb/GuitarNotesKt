package by.mogyjib.guitarnotes.main.songs

import android.view.View
import android.view.ViewGroup
import by.mogyjib.guitarnotes.base.recycler.BaseRecyclerViewAdapter
import by.mogyjib.guitarnotes.base.recycler.BaseViewHolder
import by.mogyjib.guitarnotes.data.models.Song
import android.view.LayoutInflater
import android.widget.TextView
import butterknife.BindView
import by.mogyjib.guitarnotes.R


class SongsAdapter : BaseRecyclerViewAdapter<Song, SongsAdapter.SongsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.song_list_item, parent, false)
        return SongsViewHolder(itemView)
    }

    class SongsViewHolder(itemView: View) : BaseViewHolder<Song>(itemView) {
        @BindView(R.id.song_name) lateinit var nameTV: TextView
        @BindView(R.id.song_name) lateinit var authorTV: TextView

        override fun bindData(song: Song) {
            super.bindData(song)
            nameTV.text = song.name
            authorTV.text = song.author
        }
    }
}