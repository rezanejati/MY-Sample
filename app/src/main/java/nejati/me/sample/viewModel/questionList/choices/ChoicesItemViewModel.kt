package nejati.me.sample.viewModel.questionList.choices

import androidx.databinding.ObservableField
import nejati.me.service.model.questionsModel.response.Choice

class ChoicesItemViewModel (choices: Choice?) {

    var choice = ObservableField("")

    var votes = ObservableField("")



    init {
        if (choices != null) {
            choice.set(choices.choice)
            votes.set(choices.votes.toString())


        }
    }



}

