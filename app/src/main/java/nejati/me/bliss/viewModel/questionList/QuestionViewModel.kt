package nejati.me.bliss.viewModel.questionList

import android.annotation.SuppressLint
import android.os.Handler
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import io.reactivex.Observable
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import nejati.me.bliss.base.BaseViewModel
import nejati.me.bliss.base.StaticValue
import nejati.me.bliss.view.activity.question.QuestionsListActivityNavigator
import nejati.me.service.generator.SingletonService
import nejati.me.service.listener.OnServiceStatus
import nejati.me.service.model.questionsModel.response.QuestionsResponse

class QuestionViewModel : BaseViewModel<QuestionsListActivityNavigator>(),
    OnServiceStatus<ArrayList<QuestionsResponse>> {

    /**
     * When Api calling apiCall value has true
     */
    var apiCall: Boolean = false

    val questionResponse = ArrayList<QuestionsResponse>()
    var questionFilter :String ="FILTER"
    var questionListObservable = ObservableArrayList<QuestionsResponse>()
    val questionListLiveData = MutableLiveData<List<QuestionsResponse>>()
    var showProgressLayout = ObservableField<Boolean>()

    fun onQuestionItemClick(position: Int) {
        navigator!!.onDetailActivity(questionResponse.get(position).id)

    }


    override fun isInternetAvilable(status: Boolean) {
        showNoInternetLayout.set(!status)

        if (status && apiCall) {
            callQuestionsHealth(questionFilter)
            apiCall = false
        }
    }


    /**
     * QuestionList Api Error
     * @param message
     */
    override fun onError(message: String) {
        if (showNoInternetLayout.get()!!) {
            apiCall = true
        } else {
            navigator!!.onHideProgress()
            navigator!!.onServerError()
        }
    }


    /**
     * QuestionList Api Response
     * @param t Response Of QuestionList Api
     * @param statusCode Http Status Code
     */
    override fun onReady(t: ArrayList<QuestionsResponse>, statusCode: Int) {
        Handler().postDelayed({ navigator!!.onHideProgress() }, StaticValue.LoadingTime)

        if (statusCode == 200) {
            if(questionResponse.size>0){
                questionResponse.clear()
            }
            questionResponse.addAll(t)
            questionListLiveData.setValue(t)


        } else {
            Handler().postDelayed({ navigator!!.onServerError() }, StaticValue.LoadingTime)
        }
    }


    /**
     * Call Question List Api
     */
    fun callQuestionsHealth(questionFilter : String) {
        navigator!!.onShowProgress()
        SingletonService.instance.healthService().questionsListService(this, questionFilter)
    }


    /**
     *When questionListLiveData is change, Update questionListObservable
     * @param list Response Of QuestionList Api
     */
    fun setQuestionList(list: List<QuestionsResponse>) {
        questionListObservable.clear()
        questionListObservable.addAll(list)
    }


    /**
     * Question Response Filter with input text
     *
     * @param text the user input
     */
    @SuppressLint("DefaultLocale")
    fun questionFilter(text: String) {

        Observable.fromIterable(questionListObservable)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            /**
             * Filter with question name or You can add other filter
             */
            .filter({ x -> if (x.question!!.toLowerCase().contains(text.toLowerCase())) true else false })
            .toList()
            .subscribe(object : SingleObserver<List<QuestionsResponse>> {
                override fun onSubscribe(d: Disposable) {
                }

                override fun onSuccess(questions: List<QuestionsResponse>) {
                    if (questions.size>0){
                        questionListLiveData.setValue(questions)

                    }else{
                        questionFilter=text
                        callQuestionsHealth(questionFilter)

                    }

                }

                override fun onError(e: Throwable) {}
            })

    }

    override fun OnClickRetryAction() {
        callQuestionsHealth(questionFilter);
    }



}

