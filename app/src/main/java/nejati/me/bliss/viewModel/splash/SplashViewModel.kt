package nejati.me.bliss.viewModel.splash


import android.content.Intent
import android.util.Log
import androidx.databinding.ObservableField

import nejati.me.bliss.base.BaseViewModel
import nejati.me.bliss.view.activity.main.MainActivity
import nejati.me.bliss.view.activity.splash.SplashActivityNavigator
import nejati.me.service.generator.SingletonService
import nejati.me.service.listener.OnServiceStatus
import nejati.me.service.model.healthStatusModel.response.HealthStatusResponse


/**
 * Authors:
 * Reza Nejati <reza.n.j.t.i></reza.n.j.t.i>@gmail.com>
 * Copyright © 2017
 */
class SplashViewModel : BaseViewModel<SplashActivityNavigator>(),
    OnServiceStatus<HealthStatusResponse> {

    override fun onReady(t: HealthStatusResponse?, statusCode: Int) {
        if (statusCode==200){
            navigator.goToMainActivity()
        }else{
            navigator.onServerError()

        }

    }



    override fun onError(message: String?) {
    }

    var text = ObservableField<String>()

    fun OnClickRetryAction() {
      callHealthStatusApi()

    }
    fun callHealthStatusApi(){
        SingletonService.getInstance().healthService().healthService(this)
    }
}


