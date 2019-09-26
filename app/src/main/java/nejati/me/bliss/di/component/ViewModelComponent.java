package nejati.me.bliss.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import nejati.me.bliss.base.BaseApplication;
import nejati.me.bliss.di.module.ViewModelModule;

import static kotlin.text.Typography.dagger;
import static kotlin.text.Typography.dagger;
import static kotlin.text.Typography.dagger;
import static kotlin.text.Typography.dagger;

@Singleton
//@Component(modules = {ViewModelModule.class, AndroidInjectionModule.class})
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
