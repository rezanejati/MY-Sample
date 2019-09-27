package nejati.me.bliss.viewModel.splash


import android.os.Handler
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import nejati.me.bliss.base.BaseViewModel
import nejati.me.bliss.view.activity.splash.SplashActivityNavigator
import nejati.me.service.generator.SingletonService
import nejati.me.service.listener.OnServiceStatus
import nejati.me.service.model.healthStatusModel.response.HealthStatusResponse

class SplashViewModel : BaseViewModel<SplashActivityNavigator>(),
    OnServiceStatus<HealthStatusResponse> {

    var showRertryLayout = ObservableField<Boolean>()


    override fun onReady(t: HealthStatusResponse?, statusCode: Int) {
        if (statusCode == 200) {
            navigator.onServerSuccess()

        } else {
            navigator.onServerError()

        }

    }


    override fun onError(message: String?) {
    }


    fun OnClickRetryAction() {
        navigator.onLoadingLayout()
        Handler().postDelayed({ callHealthStatusApi()}, 4000)



    }

    fun callHealthStatusApi() {
        SingletonService.getInstance().healthService().healthService(this)
    }
}


