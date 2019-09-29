package nejati.me.service.generator

import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import nejati.me.service.di.component.NetComponent
import nejati.me.service.part.HealthService
import okhttp3.OkHttpClient

class SingletonService private constructor() {
    private var netComponent: NetComponent? = null

    var serviceGenerator: ServiceGenerator? = null @Inject set

    var okHttpClient: OkHttpClient? = null @Inject set


    fun setNetComponent(netComponent: NetComponent): SingletonService {
        this.netComponent = netComponent
        return this
    }

    fun inject() {
        val componentService = DaggerComponentService.builder().netComponent(netComponent).build()
        componentService.inject(this)
    }

    fun healthService(): HealthService {
        return HealthService(serviceGenerator!!)
    }

    companion object {
        val instance = SingletonService()
    }


}
