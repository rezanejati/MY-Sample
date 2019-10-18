package nejati.me.sample.viewModel.questionList

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import nejati.me.sample.view.adapter.CustomClickListener
import nejati.me.service.model.questionsModel.response.Choice
import nejati.me.service.model.questionsModel.response.QuestionsResponse

class QuestionItemViewModel(questionsResponse: QuestionsResponse?, private val customClickListener: CustomClickListener) {
    var imageUrl = ObservableField("")
    var question = ObservableField("")
    var publishAt = ObservableField("")

    var choiceList = ObservableArrayList<Choice>()


    init {
        if (questionsResponse != null) {

            imageUrl.set(questionsResponse.imageUrl)

            question.set(questionsResponse.question)

            publishAt.set(questionsResponse.publishedAt)

            if(questionsResponse.choices!=null){
                choiceList.addAll(questionsResponse.choices!!)

            }
        }
    }

    fun onQuestionClick(t: QuestionItemViewModel) {
        customClickListener.itemClicked(t)
    }

}
