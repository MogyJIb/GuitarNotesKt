package by.mogyjib.guitarnotes.main.presentation.songs

import android.graphics.Paint
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import by.mogyjib.guitarnotes.R
import by.mogyjib.guitarnotes.base.view.BaseActivity
import by.mogyjib.guitarnotes.utils.px
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.shape.*
import kotlinx.android.synthetic.main.activity_song.*

class SongActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song)

        /* Init top bar title */
        val shapePathModel = ShapePathModel().apply {
            bottomRightCorner = object : CornerTreatment() {
                val size = px(20)
                override fun getCornerPath(angle: Float, interpolation: Float, shapePath: ShapePath) {
                    shapePath.reset(shapePath.startX, size * interpolation)
                    shapePath.lineTo(shapePath.endX, size * interpolation)
                }
            }
        }

        top_bar.background = MaterialShapeDrawable(shapePathModel).apply {
            setTint(ContextCompat.getColor(this@SongActivity, R.color.primary))
            paintStyle = Paint.Style.FILL
        }
    }

    override fun onSupportNavigateUp() = router().navigateUp()
    override fun router() = Navigation.findNavController(this, R.id.song_nav_host_fragment)

    fun bottomBar(): BottomAppBar = bottom_app_bar
    fun bottomBarButton(): FloatingActionButton = bottom_app_bar_button
}