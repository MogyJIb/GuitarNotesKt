package by.mogyjib.guitarnotes.base


interface OnClickListener<T> {
    fun onClicked(item: T)
}

interface OnLongClickListener<T> {
    fun onLongClicked(item: T): Boolean
}