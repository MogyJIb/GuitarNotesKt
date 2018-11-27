package by.mogyjib.guitarnotes.main.presentation.songs

import android.os.Bundle
import android.text.BoringLayout
import androidx.navigation.Navigation
import by.mogyjib.guitarnotes.R
import by.mogyjib.guitarnotes.main.presentation.base.view.BaseActivity
import by.mogyjib.guitarnotes.utils.isVisible
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_song.*

class SongActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song)
    }

    override fun onSupportNavigateUp() = router().navigateUp()
    override fun router() = Navigation.findNavController(this, R.id.song_nav_host_fragment)

    fun bottomBar(): BottomAppBar = bottom_app_bar
    fun bottomBarButton(): FloatingActionButton = bottom_app_bar_button

    fun toggleBottomBarButton(toggleFabAlignment: Boolean = false) {
        if (bottom_app_bar_button.isVisible()) {
            bottom_app_bar_button.hide(object : FloatingActionButton.OnVisibilityChangedListener() {
                override fun onHidden(fab: FloatingActionButton?) {
                    if (toggleFabAlignment)
                        bottom_app_bar.toggleFabAlignment()
                    bottom_app_bar_button.show()
                }
            })
        }
    }

    private fun BottomAppBar.toggleFabAlignment() {
        fabAlignmentMode =
                if (fabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER)
                    BottomAppBar.FAB_ALIGNMENT_MODE_END
                else
                    BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
    }
}