package nejati.me.bliss.view.activity.detail

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import nejati.me.bliss.BR

import nejati.me.bliss.R
import nejati.me.bliss.base.BaseActivity
import nejati.me.bliss.databinding.ActivityDetailQuestionBinding
import nejati.me.bliss.databinding.ActivityQestionsListBinding
import nejati.me.bliss.view.activity.question.QuestionsListActivityNavigator
import nejati.me.bliss.viewModel.detail.DetailViewModel


class DetailQuestionActivity(
    override var bindingVariable: Int = BR.viewModel,
    override var layoutRes: Int = R.layout.activity_detail_question) :
    BaseActivity<ActivityDetailQuestionBinding, DetailViewModel>(), DetailQuestionNavigator {

    override fun onShowProgress() {
        viewModel!!.showProgressLayout.set(true)
        viewModel!!.showRertryLayout.set(false)    }

    override fun onHideProgress() {
        viewModel!!.showProgressLayout.set(false)
    }

    override fun onServerError() {
        viewModel!!.showRertryLayout.set(true)
    }


    override fun getViewModel(): Class<DetailViewModel> {
        return DetailViewModel::class.java

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel!!.navigator = this
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true);
        viewModel!!.questionIdText.set("Question ID: "+intent.extras!!.getInt("question_list_id"))
        viewModel!!.questionId.set(intent.extras!!.getInt("question_list_id"))
        viewModel!!.callDetailQuestionApi(viewModel!!.questionId.get()!!)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.getItemId()
        if (id == android.R.id.home) {
            finish()
        }
        if (id == R.id.btnShare) {
            if (viewModel!!.detailQ.get() != null) {
                val sharingIntent = Intent(Intent.ACTION_SEND)
                sharingIntent.type = "text/plain"
                sharingIntent.putExtra(
                    android.content.Intent.EXTRA_SUBJECT,
                    "This is Question Detail"
                )
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, viewModel!!.detailQ.get())
                startActivity(
                    Intent.createChooser(sharingIntent, "share").addFlags(
                        Intent.FLAG_ACTIVITY_NEW_TASK
                    )
                )
            } else {
                Toast.makeText(this, "There is nothing content", Toast.LENGTH_SHORT).show()

            }


        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return super.onCreateOptionsMenu(menu)
    }
}
