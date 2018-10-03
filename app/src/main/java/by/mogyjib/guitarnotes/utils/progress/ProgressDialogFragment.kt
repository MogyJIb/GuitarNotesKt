package by.mogyjib.guitarnotes.utils.progress

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import by.mogyjib.guitarnotes.R

class ProgressDialogFragment : DialogFragment() {

    companion object {
        @JvmStatic
        fun newInstance() = ProgressDialogFragment()

        @JvmStatic
        fun actionWithProgress(fragmentManager: FragmentManager, tag: String = "_progressDialog", action: () -> Unit) {
            val progressDialog = ProgressDialogFragment()
            progressDialog.show(fragmentManager, tag)
            action()
            progressDialog.dismiss()
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(false)
        return dialog
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedState: Bundle?) :View?
            = inflater.inflate(R.layout.dialog_progress, container, false)

}