package nejati.me.service.model.healthStatusModel.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class HealthStatusResponse {

    @SerializedName("status")
    @Expose
    var status: String? = null

}
