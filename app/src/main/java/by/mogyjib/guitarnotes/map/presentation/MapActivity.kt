package by.mogyjib.guitarnotes.map.presentation

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.navigation.Navigation
import by.mogyjib.guitarnotes.R
import by.mogyjib.guitarnotes.base.view.BaseActivity

const val LOCATION_PERMISSIONS_REQUEST_CODE = 110

class MapActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSIONS_REQUEST_CODE
        )
    }

    override fun onSupportNavigateUp() = router().navigateUp()
    override fun router() = Navigation.findNavController(this, R.id.map_nav_host_fragment)
}
