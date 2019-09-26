package nejati.me.bliss.base;



import androidx.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseViewModel<N> extends ViewModel
{
    private N mNavigator;

    private CompositeDisposable mCompositeDisposable;

    public BaseViewModel()
    {
        this.mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    protected void onCleared()
    {
        mCompositeDisposable.dispose();
        super.onCleared();
    }

    public CompositeDisposable getCompositeDisposable()
    {
        return mCompositeDisposable;
    }

    public N getNavigator()
    {
        return mNavigator;
    }

    public void setNavigator(N mNavigator)
    {
        this.mNavigator = mNavigator;
    }

//    public void setIsLoading(boolean isLoading)
//    {
//        this.isLoading.set(isLoading);
//    }
}
