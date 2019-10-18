package nejati.me.sample.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import nejati.me.sample.base.BaseApplication;
import nejati.me.sample.di.module.ViewModelModule;

@Singleton
@Component(modules = {ViewModelModule.class})
public interface ViewModelComponent
{

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        ViewModelComponent build();
    }

    void inject(BaseApplication App);
}
