package bonch.dev.school.ui.models
import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*
import java.text.*

@Parcelize
data class Message(val msgId:Int, val msgText: String?, val sentDate: String?, val isUser:Boolean):Parcelable {


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