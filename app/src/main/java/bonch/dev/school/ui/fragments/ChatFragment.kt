package bonch.dev.school.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import bonch.dev.school.R
import bonch.dev.school.ui.activities.MainAppActivity

class ChatFragment() : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.chat_fragment,container,false)
        val sendButton: ImageButton =view.findViewById(R.id.send_message_button)
        sendButton.setOnClickListener(){
            (activity as MainAppActivity).replace()
        }
        return view
    }

}