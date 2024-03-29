package bonch.dev.school.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import bonch.dev.school.R
import bonch.dev.school.ui.activities.MainAppActivity

class ProfileFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.profile_fragment,container,false)
        val changePasswordButton: Button =view.findViewById(R.id.change_password_button)
        changePasswordButton.setOnClickListener(){
            (activity as MainAppActivity).passFrag()
        }
        return view

    }
}