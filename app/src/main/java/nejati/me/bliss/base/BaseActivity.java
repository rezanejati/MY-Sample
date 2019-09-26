package nejati.me.bliss.base;


import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import javax.inject.Inject;

public abstract class BaseActivity<D extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity {
    protected D dataBinding;
    protected V viewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel());
        dataBinding = DataBindingUtil.setContentView(this, getLayoutRes());
        dataBinding.setVariable(getBindingVariable(), viewModel);
        dataBinding.executePendingBindings();
    }
    public abstract int getBindingVariable();

    protected abstract Class<V> getViewModel();

    @LayoutRes
    protected abstract int getLayoutRes();

}
