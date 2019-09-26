package nejati.me.bliss.view.activity.splash

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import nejati.me.bliss.BR


import nejati.me.bliss.R
import nejati.me.bliss.base.BaseActivity
import nejati.me.bliss.databinding.ActivitySplashBinding
import nejati.me.bliss.view.activity.main.MainActivity
import nejati.me.bliss.viewModel.splash.SplashViewModel

class SplashActivity :  BaseActivity<ActivitySplashBinding, SplashViewModel>(),
    SplashActivityNavigator  {
    override fun onServerError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun goToMainActivity() {
        startActivity(Intent(this@SplashActivity, MainActivity::class.java))

    }

    override fun getBindingVariable(): Int {
        return BR.viewModel

    }

    override fun getViewModel(): Class<SplashViewModel> {
        return SplashViewModel::class.java
    }



    override fun getLayoutRes(): Int {
        return R.layout.activity_splash
    }

    override fun showProgress() {
    }

    override fun hideProgress() {
    }





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this
        viewModel.callHealthStatusApi()

    }
}
