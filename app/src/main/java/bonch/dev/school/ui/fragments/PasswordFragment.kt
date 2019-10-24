package bonch.dev.school.ui.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import bonch.dev.school.R

class PasswordFragment: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder= AlertDialog.Builder(activity)

        val inflater= activity?.layoutInflater?.inflate(R.layout.password_fragment,null)
        builder.setView(inflater)
        return builder.create()
    }

}