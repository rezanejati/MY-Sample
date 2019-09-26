package nejati.me.service.generator;
import javax.inject.Inject;
import nejati.me.service.di.component.NetComponent;
import nejati.me.service.part.HealthService;
import okhttp3.OkHttpClient;

public class SingletonService {
    private NetComponent netComponent;
    @Inject
    ServiceGenerator serviceGenerator;
    @Inject
    OkHttpClient okHttpClient;
    private static final SingletonService ourInstance = new SingletonService();

    public static SingletonService getInstance() {
        return ourInstance;
    }

    public SingletonService setNetComponent(NetComponent netComponent) {
        this.netComponent = netComponent;
        return this;
    }

    public void inject() {
        ComponentService componentService = DaggerComponentService.builder().netComponent(netComponent).build();
        componentService.inject(this);
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    private SingletonService() {
    }

    public HealthService healthService() {
        return new HealthService(serviceGenerator);
    }




}
