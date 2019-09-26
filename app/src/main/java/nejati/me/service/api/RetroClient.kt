package nejati.me.service.api

import io.reactivex.Observable
import nejati.me.service.helper.Const
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RetroClient {

    //The Health Url is get and response is string
    @get:GET(Const.HEALTH)
    val healthStatus: Observable<Response<String>>
}
