package bonch.dev.school.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bonch.dev.school.R
import bonch.dev.school.ui.models.Message
import kotlinx.android.synthetic.main.profile_fragment.view.*
import java.text.FieldPosition
import java.text.SimpleDateFormat
import java.util.*

class MessageRecyclerItems(val messageList:MutableList<Message>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            myMsg-> myViewHolder((LayoutInflater.from(parent.context).inflate(R.layout.user_message_item,parent,false)))
            otherMsg-> otherViewHolder((LayoutInflater.from(parent.context).inflate(R.layout.other_message_item,parent,false)))
            else -> myViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.user_message_item,parent,false))
        }
    }

    val myMsg=1
    val otherMsg=2

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(getItemViewType(position)){
            myMsg-> (holder as myViewHolder).bind(position)
            otherMsg->(holder as otherViewHolder).bind(position)
        }
    }


    override fun getItemCount(): Int {
        return messageList.size
    }


    inner class otherViewHolder(v:View):RecyclerView.ViewHolder(v){
        val otherMsgText:TextView=v.findViewById(R.id.other_message_text)
        val otherDateText:TextView=v.findViewById(R.id.other_message_date)
        val otherNameText:TextView=v.findViewById(R.id.other_message_sender_name)
        val formatDate = SimpleDateFormat("hh:mm:ss")
        fun bind(position: Int){
            otherDateText.text=formatDate.format(Date())
            otherMsgText.text="${messageList[position].msgText}"
            otherNameText.text="конго бонго"
        }
    }
    inner class myViewHolder(v:View):RecyclerView.ViewHolder(v){
        val showText:TextView =v.findViewById(R.id.show_message_text)
        val showDate:TextView=v.findViewById(R.id.sent_message_date)
        val formatDate = SimpleDateFormat("hh:mm:ss")
        fun bind(position: Int){
            showText.text="${messageList[position].msgText}"
            showDate.text=formatDate.format(Date())
        }

    }
    override fun getItemViewType(position: Int): Int {
        if (messageList.get(position).isUser){
            return myMsg
        }
        else return otherMsg
    }

}

