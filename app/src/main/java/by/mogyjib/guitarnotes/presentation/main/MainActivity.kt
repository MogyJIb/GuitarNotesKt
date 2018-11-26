package by.mogyjib.guitarnotes.presentation.main

import android.os.Bundle
import androidx.navigation.Navigation
import by.mogyjib.guitarnotes.R
import by.mogyjib.guitarnotes.presentation.base.view.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onSupportNavigateUp() = router().navigateUp()
      override fun router() = Navigation.findNavController(this, R.id.main_nav_host_fragment)
}
