package by.mogyjib.guitarnotes.base.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.mogyjib.guitarnotes.base.OnClickListener
import by.mogyjib.guitarnotes.base.OnLongClickListener


abstract class BaseViewHolder<T : Any>(
        itemView: View
) : RecyclerView.ViewHolder(itemView) {
    protected lateinit var data: T

    var onClickListener: OnClickListener<T>? = null
        set(value) {
            value?.let { listener ->
                itemView.setOnClickListener { listener.onClicked(data) }
                field = listener
            }
        }

    var onLongClickListener: OnLongClickListener<T>? = null
        set(value) {
            value?.let { listener ->
                itemView.setOnLongClickListener { listener.onLongClicked(data) }
                field = listener
            }
        }

    open fun bindData(data: T) {
        this.data = data
    }
}