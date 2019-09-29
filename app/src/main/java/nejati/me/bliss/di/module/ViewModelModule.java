package nejati.me.bliss.di.module;


import androidx.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import nejati.me.bliss.viewModel.factory.ViewModelFactory;

@Module
public abstract class ViewModelModule
{


    @Binds
    @SuppressWarnings("unused")
    abstract ViewModelProvider.Factory bindsViewModelFactory(ViewModelFactory viewModelFactory);
}
