package by.mogyjib.guitarnotes.main.songs.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.mogyjib.guitarnotes.R
import by.mogyjib.guitarnotes.base.view.BaseContract
import by.mogyjib.guitarnotes.base.view.BaseFragment


class SongListFragment : BaseFragment(), SongListContract.View {

    override val presenter: BaseContract.Presenter
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_songlist, container, false)
    }
}