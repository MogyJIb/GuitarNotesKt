package by.mogyjib.guitarnotes.main.presentation.splash.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.mogyjib.guitarnotes.R
import by.mogyjib.guitarnotes.main.presentation.base.view.BaseContract
import by.mogyjib.guitarnotes.main.presentation.base.view.BaseFragment
import org.koin.android.ext.android.inject


class SplashFragment : BaseFragment(), BaseContract.View {

    override val presenter: SplashPresenter by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_splash, container, false)

}
