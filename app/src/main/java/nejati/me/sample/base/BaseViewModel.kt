package nejati.me.sample.base


import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

import io.reactivex.disposables.CompositeDisposable

/**
 * @param N Activity Navigator
 */
abstract class BaseViewModel<N> : ViewModel() {

    var showRertryLayout = ObservableField<Boolean>(false)
    var showNoInternetLayout = ObservableField<Boolean>(false)

    var navigator: N? = null

    /**
     * Retry Call Api Widget
     */
    abstract fun OnClickRetryAction()

    /**
     * Monitoriing Internet Connection
     * @param status true  is Internet available, false is Internet not available
     */
    abstract fun isInternetAvilable(status:Boolean)

    val compositeDisposable: CompositeDisposable

    init {
        this.compositeDisposable = CompositeDisposable()
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()

    }
}
