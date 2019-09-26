package nejati.me.service.api;

import io.reactivex.Observable;
import nejati.me.service.helper.Const;
import nejati.me.service.model.healthStatusModel.response.HealthStatusResponse;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface RetroClient {
    @GET(Const.HEALTH)
    Observable<Response<HealthStatusResponse>> health();
}
