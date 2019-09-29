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
    override var layoutRes: Int = R.layout.activity_detail_question
) :
    BaseActivity<ActivityDetailQuestionBinding, DetailViewModel>(), DetailQuestionNavigator {
    override fun onServerSuccess() {

    }

    override fun onServerError() {
    }

    override fun onLoadingLayout() {
    }

    override fun getViewModel(): Class<DetailViewModel> {
        return DetailViewModel::class.java

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel!!.navigator = this
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true);
        Toast.makeText(this, intent.extras!!.getInt("question_list_id").toString(), Toast.LENGTH_SHORT).show()


    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.getItemId()
        if (id == android.R.id.home) {
            finish()
        }
        if (id == R.id.btnShare) {
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject")
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "test")
            startActivity(
                Intent.createChooser(sharingIntent, "share").addFlags(
                    Intent.FLAG_ACTIVITY_NEW_TASK
                )
            )

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return super.onCreateOptionsMenu(menu)
    }
}
