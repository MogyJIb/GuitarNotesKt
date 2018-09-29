package by.mogyjib.guitarnotes.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import by.mogyjib.guitarnotes.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onSupportNavigateUp() =
            Navigation.findNavController(this, R.id.splash_nav_host_fragment).navigateUp()

}
