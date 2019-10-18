package nejati.me.sample.view.activity.question;


public interface QuestionsListActivityNavigator {

    void onShowProgress();

    void onHideProgress();

    void onServerError();

    void onDetailActivity(Integer id);



}
