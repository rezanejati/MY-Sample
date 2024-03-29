package nejati.me.service.part

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import nejati.me.service.generator.ServiceGenerator
import nejati.me.service.listener.OnServiceStatus
import retrofit2.Response

abstract class BasePart
/**
 * @param serviceGenerator
 */
    (val serviceGenerator: ServiceGenerator) {

    /**
     * @return
     */
    protected abstract val part: BasePart


    /**
     * @param observable
     * @param listener
     * @param <T>
    </T> */
    fun <T> start(observable: Observable<Response<T>>, listener: OnServiceStatus<T>) {
        call(observable, listener)
    }


    /**
     * @param observable
     * @param listener
     * @param <T>
    </T> */
    private fun <T> call(observable: Observable<Response<T>>, listener: OnServiceStatus<T>) {
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .unsubscribeOn(Schedulers.io())
            .subscribe(object : Observer<Response<T>> {
                override fun onSubscribe(d: Disposable) {}

                override fun onNext(value: Response<T>) {
                    value.body()?.let { listener.onReady(it, value.code()) }
                }

                override fun onError(e: Throwable) {
                    e.message?.let { listener.onError(it) }
                }

                override fun onComplete() {

                }
            })
    }


}
