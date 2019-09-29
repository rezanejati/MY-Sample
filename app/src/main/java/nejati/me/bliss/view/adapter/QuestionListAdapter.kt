package nejati.me.bliss.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup

import nejati.me.bliss.base.BaseAdapter
import nejati.me.bliss.base.BaseViewHolder
import nejati.me.bliss.databinding.QuestionListItemBinding
import nejati.me.bliss.viewModel.questionList.QuestionItemViewModel
import nejati.me.bliss.viewModel.questionList.QuestionViewModel
import nejati.me.service.model.questionsModel.response.QuestionsResponse

class QuestionListAdapter(
    private val questionItems: MutableList<QuestionsResponse>,
    questionViewModel: QuestionViewModel
) :
    BaseAdapter<BaseViewHolder, QuestionsResponse>() {

    var questionViewModel: QuestionViewModel

    init {
       this.questionViewModel=questionViewModel
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): BaseViewHolder {
        val adapterBinding = QuestionListItemBinding.inflate(
            LayoutInflater.from(viewGroup.context),
            viewGroup, false)

        return QuestionListViewHolder(adapterBinding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int {
        return questionItems.size
    }

    inner class QuestionListViewHolder(private val adapterBinding: QuestionListItemBinding) :
        BaseViewHolder(adapterBinding.root), CustomClickListener {

        private var questionItemViewModel: QuestionItemViewModel? = null

        override fun onBind(position: Int) {
            if (questionItems.size > 0) {
                val questionListItem = questionItems[position]
                questionItemViewModel = QuestionItemViewModel(questionListItem, this)
                adapterBinding.viewModel = questionItemViewModel

            }
        }


        override fun itemClicked(f: QuestionItemViewModel) {
            questionViewModel.onQuestionItemClick(adapterPosition)
        }
    }
}
