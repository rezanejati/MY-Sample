package nejati.me.bliss.view.activity.splash;

import android.content.Intent;

/**
 * Authors:
 * Reza Nejati <reza.n.j.t.i@gmail.com>
 * Copyright © 2017
 */
public interface SplashActivityNavigator {
    void showProgress();
    void hideProgress();
    void goToMainActivity();
    void onServerError();

}
