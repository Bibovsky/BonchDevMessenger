package bonch.dev.school.ui.fragments

import android.graphics.Color
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bonch.dev.school.R
import bonch.dev.school.ui.MessageRecyclerItems
import bonch.dev.school.ui.models.Message
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ChatFragment() : Fragment() {
    private lateinit var msgList:MutableList<Message>
    private lateinit var lm:LinearLayoutManager
    private lateinit var msgRecycler: RecyclerView
    private lateinit var divider: LinearLayout
    private var recyclerViewStateBundle: Bundle = Bundle()
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
        divider=view.findViewById(R.id.divider2)
        msgEdit.setOnFocusChangeListener{view,hasFocus ->
            if (msgEdit.hasFocus()){
                divider.setBackgroundResource(R.drawable.divider_active)
            }else{
                divider.setBackgroundResource(R.drawable.divider_chat)
            }
        }

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



    override fun onPause() {
        super.onPause()
        //onSaveInstanceState()
        Log.d("onPause","${ArrayList<Parcelable>(msgList)}")
        recyclerViewStateBundle = Bundle().apply { putParcelableArrayList("saveData",ArrayList<Parcelable>(msgList))  }


    }

    /*override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        //var parcArr: MutableList<Message> =


        /*var bundle:Bundle=Bundle().apply { putParcelableArrayList("saveData",ArrayList<Parcelable>(msgList))

        }
        outState.putBundle("bundle",bundle)*/
    }*/

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        /*if (savedInstanceState!=null){
            Log.d("SAVESTATE","${savedInstanceState}")
        }
        //Toast.makeText(this.context,"onActivityCreated",Toast.LENGTH_SHORT).show()
        Log.d("what","AAAAAAAAAAAAAAAAAAA")
        if (savedInstanceState!=null && savedInstanceState.get("saveData")!=null){
            msgList=savedInstanceState.get("saveData") as MutableList<Message>
            Toast.makeText(context,"savedInstanceState!=null",Toast.LENGTH_SHORT).show()
        }*/
        if (recyclerViewStateBundle!=null && recyclerViewStateBundle.get("saveData")!=null){
            msgList.clear()
            msgList.addAll(recyclerViewStateBundle.get("saveData") as MutableList<Message>)

            Log.d("onPause","${recyclerViewStateBundle.get("saveData")}")
            //Toast.makeText(context,"savedInstanceState!=null",Toast.LENGTH_SHORT).show()
        }
    }
}