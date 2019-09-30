package nejati.me.bliss.view.activity.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import nejati.me.bliss.BR


import nejati.me.bliss.R
import nejati.me.bliss.base.BaseActivity
import nejati.me.bliss.base.StaticValue
import nejati.me.bliss.databinding.ActivitySplashBinding
import nejati.me.bliss.view.activity.question.QuestionsListActivity
import nejati.me.bliss.viewModel.splash.SplashViewModel
import nejati.me.service.helper.Const

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
