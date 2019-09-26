package nejati.me.service.generator

import javax.inject.Inject
import nejati.me.service.di.component.NetComponent
import okhttp3.OkHttpClient

class SingletonService private constructor() {
    private var netComponent: NetComponent? = null
    @Inject
    internal var serviceGenerator: ServiceGenerator? = null
    @Inject
    var okHttpClient: OkHttpClient? = null
        internal set

    fun setNetComponent(netComponent: NetComponent): SingletonService {
        this.netComponent = netComponent
        return this
    }

    fun inject() {
        val componentService = DaggerComponentService.builder().netComponent(netComponent).build()
        componentService.inject(this)
    }

    companion object {
        val instance = SingletonService()
    }


}
