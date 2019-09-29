package nejati.me.service.model.questionsModel.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class QuestionsResponse {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("question")
    @Expose
    var question: String? = null
    @SerializedName("image_url")
    @Expose
    var imageUrl: String? = null
    @SerializedName("thumb_url")
    @Expose
    var thumbUrl: String? = null
    @SerializedName("published_at")
    @Expose
    var publishedAt: String? = null
    @SerializedName("choices")
    @Expose
    var choices: List<Choice>? = null

}
