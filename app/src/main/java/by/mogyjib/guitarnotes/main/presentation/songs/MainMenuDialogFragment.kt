package by.mogyjib.guitarnotes.main.presentation.songs

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import by.mogyjib.guitarnotes.R
import by.mogyjib.guitarnotes.base.view.BaseDialogFragment
import kotlinx.android.synthetic.main.main_menu_layout.*

class MainMenuDialogFragment : BaseDialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.main_menu_layout, container, false)

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        setStyle(STYLE_NO_TITLE, R.style.Widget_AppTheme_Dialog)
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window?.run {
            requestFeature(Window.FEATURE_NO_TITLE)
            setBackgroundDrawableResource(android.R.color.transparent)
            setDimAmount(0f)
        }
        return dialog
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        view.setOnClickListener { dismiss() }

        map_button.setOnClickListener {
            router().navigate(R.id.action_to_map_activity)
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        dialog.window?.run {
            setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            decorView.background = null
            decorView.setPadding(0, 0, 0, 0)
        }
    }
}