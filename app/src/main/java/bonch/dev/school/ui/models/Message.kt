package bonch.dev.school.ui.models
import java.text.DateFormat
import java.util.*
import java.text.*

data class Message(val msgId:Int,val msgText:String,val sentDate:String,val isUser:Boolean){
    class MessageLab{
        val msgList:MutableList<Message>
        val formatDate = SimpleDateFormat("hh:mm:ss")

        init {
            msgList= mutableListOf()
            for (i in 1..20){
                val userMessage = Message(i,"я стив другс №$i",formatDate.format(Date()),false)
                msgList.add(userMessage)
            }
        }
    }
}