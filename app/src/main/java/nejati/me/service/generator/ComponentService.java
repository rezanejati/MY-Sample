package nejati.me.service.generator;


import dagger.Component;
import nejati.me.service.di.component.NetComponent;
import nejati.me.service.scope.CustomScope;


@CustomScope
@Component(dependencies = NetComponent.class)
public interface ComponentService {
    void inject(SingletonService singletonService);
}
