package nejati.me.bliss.base


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork

import javax.inject.Inject

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

abstract class BaseActivity<D : ViewDataBinding, V : BaseViewModel<*>> : AppCompatActivity() {
    protected var dataBinding: D?=null
    protected var viewModel: V?=null

    var viewModelFactory: ViewModelProvider.Factory? = null @Inject set

    abstract val bindingVariable: Int

    @get:LayoutRes
    protected abstract val layoutRes: Int


    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel())
        dataBinding = DataBindingUtil.setContentView(this, layoutRes)
        dataBinding!!.setVariable(bindingVariable, viewModel)
        dataBinding!!.executePendingBindings()

        ReactiveNetwork
            .observeInternetConnectivity()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { isConnectedToInternet -> viewModel!!.isInternetAvilable(isConnectedToInternet!!) }
    }

    protected abstract fun getViewModel(): Class<V>

}
