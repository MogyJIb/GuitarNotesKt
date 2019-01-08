package by.mogyjib.guitarnotes.utils.extentions

import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat


fun Activity.isPermissionGranted(permission: String, action: () -> Unit = {}): Boolean {
    if (ActivityCompat.checkSelfPermission(
                    this, permission) == PackageManager.PERMISSION_GRANTED) {
        action()
        return true
    }
    return false
}
