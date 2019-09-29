package nejati.me.bliss.view.activity.question;

/**
 * Authors:
 * Reza Nejati <reza.n.j.t.i@gmail.com>
 * Copyright © 2017
 */
public interface QuestionsListActivityNavigator {

    void onShowProgress();

    void onHideProgress();

    void onServerError();

    void onDetailActivity(Integer id);



}
