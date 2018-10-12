package by.mogyjib.guitarnotes.base.view

abstract class BasePresenter<V : BaseContract.View> : BaseContract.Presenter<V> {

    protected lateinit var view: V

    override fun onViewCreated(view: V) {
        this.view = view
        init()
    }
}