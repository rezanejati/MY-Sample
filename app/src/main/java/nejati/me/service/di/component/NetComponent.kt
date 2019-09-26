package nejati.me.service.di.component

import javax.inject.Singleton
import dagger.Component
import nejati.me.service.di.module.NetModule
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@Singleton
@Component(modules = [NetModule::class])
interface NetComponent {
    fun retrofit(): Retrofit
    fun okhttp(): OkHttpClient

}

