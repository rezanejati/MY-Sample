package nejati.me.bliss.view.activity.splash

import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import com.airbnb.lottie.LottieDrawable
import nejati.me.bliss.BR


import nejati.me.bliss.R
import nejati.me.bliss.base.BaseActivity
import nejati.me.bliss.databinding.ActivitySplashBinding
import nejati.me.bliss.view.activity.main.MainActivity
import nejati.me.bliss.viewModel.splash.SplashViewModel

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>(),
    SplashActivityNavigator {
    override fun onLoadingLayout() {
        viewModel.showRertryLayout.set(false)
        dataBinding.lvLoading.setAnimation("lottie/loading.json")
        dataBinding.lvLoading.playAnimation()


    }


    override fun onServerError() {
        viewModel.showRertryLayout.set(true)
        dataBinding.lvLoading.setAnimation("lottie/oops.json")
        dataBinding.lvLoading.playAnimation()


    }

    override fun onServerSuccess() {
        startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        this.finish()

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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this
        onLoadingLayout()
        Handler().postDelayed({ viewModel.callHealthStatusApi() }, 4000)


    }
}
