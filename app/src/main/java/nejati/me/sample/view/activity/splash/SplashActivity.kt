package nejati.me.sample.view.activity.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import nejati.me.sample.BR


import nejati.me.sample.R
import nejati.me.sample.base.BaseActivity
import nejati.me.sample.base.StaticValue
import nejati.me.sample.databinding.ActivitySplashBinding
import nejati.me.sample.view.activity.question.QuestionsListActivity
import nejati.me.sample.viewModel.splash.SplashViewModel

class SplashActivity(override var bindingVariable: Int=BR.viewModel,
                     override var layoutRes: Int=R.layout.activity_splash)
    : BaseActivity<ActivitySplashBinding, SplashViewModel>(),
    SplashActivityNavigator {




    override fun onLoadingLayout() {
        viewModel!!.showRertryLayout.set(false)


    }


    override fun onServerError() {
        viewModel!!.showRertryLayout.set(true)


    }

    override fun onServerSuccess() {
        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity, QuestionsListActivity::class.java))
            this.finish()
        }, 4000)



    }


    override fun getViewModel(): Class<SplashViewModel> {
        return SplashViewModel::class.java
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel!!.navigator = this
        onLoadingLayout()
        Handler().postDelayed({ viewModel!!.callHealthStatusApi() }, StaticValue.SplashTime*1000)


    }
}
