package by.mogyjib.guitarnotes.map.presentation

import android.os.Bundle
import androidx.navigation.Navigation
import by.mogyjib.guitarnotes.R
import by.mogyjib.guitarnotes.base.view.BaseActivity


class MapActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onSupportNavigateUp() = router().navigateUp()
    override fun router() = Navigation.findNavController(this, R.id.splash_nav_host_fragment)
}
