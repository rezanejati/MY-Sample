package nejati.me.bliss.view.activity.question

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_qestions_list.*
import nejati.me.bliss.BR

import nejati.me.bliss.R
import nejati.me.bliss.base.BaseActivity
import nejati.me.bliss.databinding.ActivityQestionsListBinding
import nejati.me.bliss.view.activity.detail.DetailQuestionActivity
import nejati.me.bliss.viewModel.questionList.QuestionViewModel
import nejati.me.service.model.questionsModel.response.QuestionsResponse



class QuestionsListActivity(override var bindingVariable: Int=BR.viewModel,
                            override var layoutRes: Int=R.layout.activity_qestions_list) :
    BaseActivity<ActivityQestionsListBinding, QuestionViewModel>(), QuestionsListActivityNavigator, TextWatcher {

    override fun onDetailActivity(id: Int) {
        startActivity(Intent(this@QuestionsListActivity, DetailQuestionActivity::class.java)
            .putExtra("question_list_id",id))

    }


    override fun onServerError() {
        viewModel!!.showRertryLayout.set(true)
    }

    override fun afterTextChanged(s: Editable?) {
        if (dataBinding!!.etSearch.text!!.length > 2){
            viewModel!!.questionFilter(etSearch.getText().toString())

        }else
        if (dataBinding!!.etSearch.text!!.length==0){
            viewModel!!.questionListLiveData.setValue(viewModel!!.questionResponse)

        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun onHideProgress() {
        viewModel!!.showProgressLayout.set(false)

    }

    override fun onShowProgress() {
        viewModel!!.showProgressLayout.set(true)
        viewModel!!.showRertryLayout.set(false)

    }

    override fun getViewModel(): Class<QuestionViewModel> {
        return QuestionViewModel::class.java
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel!!.navigator = this
        viewModel!!.callQuestionsHealth(viewModel!!.questionFilter)
        dataBinding!!.etSearch.addTextChangedListener(this)
        viewModel!!.questionListLiveData.observe(this, Observer<List<QuestionsResponse>> { s -> viewModel!!.setQuestionList(s) })


    }



}
