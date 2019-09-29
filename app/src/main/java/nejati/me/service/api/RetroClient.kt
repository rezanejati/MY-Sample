package nejati.me.service.api

import io.reactivex.Observable
import nejati.me.service.helper.Const
import nejati.me.service.model.healthStatusModel.response.HealthStatusResponse
import nejati.me.service.model.questionsModel.response.QuestionsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroClient {

    @GET(Const.HEALTH)
    fun healthStatus(): Observable<Response<HealthStatusResponse>>

    @GET(Const.QUESTIONS)
    fun questions(@Query("question_filter") filterName: String):
            Observable<Response<ArrayList<QuestionsResponse>>>

    @GET(Const.QUESTIONSDETAIL)
    fun questionsDetail(@Query("question_id") questionId: Int):
            Observable<Response<ArrayList<QuestionsResponse>>>
}
