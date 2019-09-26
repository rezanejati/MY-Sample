package nejati.me.service.di.component;

import javax.inject.Singleton;
import dagger.Component;
import nejati.me.service.di.module.NetModule;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {NetModule.class})
public interface NetComponent {
    Retrofit retrofit();
    OkHttpClient okhttp();

}

