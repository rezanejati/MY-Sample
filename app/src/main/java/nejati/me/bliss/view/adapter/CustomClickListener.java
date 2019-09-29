package nejati.me.bliss.view.adapter;

import nejati.me.bliss.viewModel.questionList.QuestionItemViewModel;
import nejati.me.service.model.questionsModel.response.QuestionsResponse;

/**
 * Authors:
 * Reza Nejati <reza.n.j.t.i@gmail.com>
 * Copyright © 2017
 */
public interface CustomClickListener {
    void itemClicked(QuestionItemViewModel t);

}
