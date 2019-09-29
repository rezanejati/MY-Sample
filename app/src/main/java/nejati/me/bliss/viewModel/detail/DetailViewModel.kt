package nejati.me.bliss.viewModel.detail

import nejati.me.bliss.base.BaseViewModel
import nejati.me.bliss.view.activity.detail.DetailQuestionNavigator
import nejati.me.bliss.view.activity.question.QuestionsListActivityNavigator
import nejati.me.bliss.view.activity.splash.SplashActivityNavigator
import nejati.me.service.generator.SingletonService
import nejati.me.service.listener.OnServiceStatus
import nejati.me.service.model.healthStatusModel.response.HealthStatusResponse

/**
 * Authors:
 * Reza Nejati <reza.n.j.t.i></reza.n.j.t.i>@gmail.com>
 * Copyright © 2017
 */
class DetailViewModel : BaseViewModel<DetailQuestionNavigator>(),
    OnServiceStatus<HealthStatusResponse> {

    /**
     * When Api calling apiCall value has true
     */
    var apiCall:Boolean=false


    override fun isInternetAvilable(status: Boolean) {
        showNoInternetLayout.set(!status)
        if (status&&apiCall){
            callHealthStatusApi()
            apiCall=false

        }

    }


    /**
     * HealthStatus Api  Response
     * @param t Response Of QuestionList Api
     * @param statusCode Http Status Code
     */
    override fun onReady(t: HealthStatusResponse, statusCode: Int) {
        if (statusCode == 200) {
          //  navigator!!.onServerSuccess()

        } else {
            navigator!!.onServerError()

        }

    }

    /**
     * HealthStatus Api Error
     * @param message
     */
    override fun onError(message: String) {
        if (showNoInternetLayout.get()!!){
            apiCall=true
        }else{
            navigator!!.onServerError()

        }
    }


    override fun OnClickRetryAction() {
      //  navigator!!.onLoadingLayout()
        callHealthStatusApi()
    }

    /**
     *HealthStatus Api
     */
    fun callHealthStatusApi() {
        SingletonService.instance.healthService().healthStatusService(this)
    }
}


