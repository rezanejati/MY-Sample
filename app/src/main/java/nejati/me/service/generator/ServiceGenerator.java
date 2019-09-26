package nejati.me.service.generator;

import javax.inject.Inject;

import nejati.me.service.api.RetroClient;
import retrofit2.Retrofit;

public class ServiceGenerator {
    private Retrofit retrofit;

    @Inject
    public ServiceGenerator(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public RetroClient createService() {
        return retrofit.create(RetroClient.class);
    }


}
