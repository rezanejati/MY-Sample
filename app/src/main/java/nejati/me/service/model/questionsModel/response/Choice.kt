package nejati.me.service.model.questionsModel.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import java.util.ArrayList

class Choice {

    @SerializedName("choice")
    @Expose
    var choice: String? = null
    @SerializedName("votes")
    @Expose
    var votes: Int? = null

}
