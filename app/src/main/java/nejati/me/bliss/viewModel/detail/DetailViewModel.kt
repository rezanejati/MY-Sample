package nejati.me.bliss.viewModel.detail

import android.os.Handler
import androidx.databinding.ObservableField
import com.google.gson.Gson
import nejati.me.bliss.base.BaseViewModel
import nejati.me.bliss.base.StaticValue
import nejati.me.bliss.view.activity.detail.DetailQuestionNavigator
import nejati.me.service.generator.SingletonService
import nejati.me.service.listener.OnServiceStatus
import nejati.me.service.model.questionsModel.response.QuestionsResponse


class DetailViewModel : BaseViewModel<DetailQuestionNavigator>(),
    OnServiceStatus<ArrayList<QuestionsResponse>> {

    /**
     * When Api calling apiCall value has true
     */
    var apiCall:Boolean=false

    val detailQ = ObservableField<String>()
    var questionId = ObservableField<Int>()
    var questionIdText = ObservableField<String>()
    var showProgressLayout = ObservableField<Boolean>()


    override fun isInternetAvilable(status: Boolean) {
        showNoInternetLayout.set(!status)
        if (status&&apiCall){
            callDetailQuestionApi(questionId.get()!!)
            apiCall=false

        }

    }


    /**
     * HealthStatus Api  Response
     * @param t Response Of QuestionList Api
     * @param statusCode Http Status Code
     */
    override fun onReady(t: ArrayList<QuestionsResponse>, statusCode: Int) {
        Handler().postDelayed({ navigator!!.onHideProgress() }, StaticValue.LoadingTime)
        if (statusCode == 200) {
            detailQ.set(Gson().toJson(t))

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
        callDetailQuestionApi(questionId.get()!!)
    }

    /**
     *HealthStatus Api
     */
    fun callDetailQuestionApi(questionId : Int) {
        navigator!!.onShowProgress()
        SingletonService.instance.healthService().questionsDetailService(this,questionId)
    }
}



