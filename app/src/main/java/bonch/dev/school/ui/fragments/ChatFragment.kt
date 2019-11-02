package bonch.dev.school.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bonch.dev.school.R
import bonch.dev.school.ui.MessageRecyclerItems
import bonch.dev.school.ui.activities.MainAppActivity
import bonch.dev.school.ui.models.Message
import kotlinx.android.synthetic.main.chat_fragment.*
import java.text.SimpleDateFormat
import java.util.*

class ChatFragment() : Fragment() {
    private lateinit var msgList:MutableList<Message>
    private lateinit var lm:LinearLayoutManager
    private lateinit var msgRecycler: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        msgList= Message.MessageLab().msgList

        val view = inflater.inflate(R.layout.chat_fragment,container,false)
        val sendButton: ImageButton =view.findViewById(R.id.send_message_button)
        var msgEdit:EditText=view.findViewById(R.id.message_et)

        val lm = LinearLayoutManager(context)
        lm.scrollToPosition(MessageRecyclerItems(msgList).itemCount-1)

        msgRecycler=view.findViewById(R.id.message_recycler_view)
        msgRecycler.layoutManager=lm
        msgRecycler.adapter = MessageRecyclerItems(msgList)

        sendButton.setOnClickListener(){


            if (msgEdit.text.isEmpty()){
                Toast.makeText(context,"Пустая строка",Toast.LENGTH_SHORT).show()
            }
            else {
                val formatDate = SimpleDateFormat("hh:mm:ss")

                msgList.add(Message(1,msgEdit.text.toString().trim(),formatDate.format(Date()),true))
                msgEdit.setText("")
                msgRecycler.scrollToPosition(MessageRecyclerItems(msgList).itemCount-1)

            }
        }
        return view
    }

}