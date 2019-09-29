package nejati.me.bliss.base

import android.app.Application
import nejati.me.bliss.di.component.DaggerViewModelComponent
import nejati.me.service.di.component.DaggerNetComponent
import nejati.me.service.di.module.NetModule
import nejati.me.service.generator.SingletonService
import nejati.me.service.helper.Const


class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val mNetComponent = DaggerNetComponent.builder()
            .netModule(NetModule(Const.BASEURl))
            .build()
        SingletonService.instance.setNetComponent(mNetComponent).inject()
        DaggerViewModelComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }
}
