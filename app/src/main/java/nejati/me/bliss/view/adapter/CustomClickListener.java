package nejati.me.bliss.view.adapter;

import nejati.me.bliss.viewModel.questionList.QuestionItemViewModel;
import nejati.me.service.model.questionsModel.response.QuestionsResponse;

public interface CustomClickListener {
    void itemClicked(QuestionItemViewModel t);

}
