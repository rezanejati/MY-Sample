package nejati.me.sample.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup

import nejati.me.sample.base.BaseAdapter
import nejati.me.sample.base.BaseViewHolder
import nejati.me.sample.databinding.ChoiceListItemBinding

import nejati.me.sample.viewModel.questionList.choices.ChoicesItemViewModel
import nejati.me.service.model.questionsModel.response.Choice

class ChoiceListAdapter(private val questionItems: MutableList<Choice>?) :
    BaseAdapter<BaseViewHolder, Choice>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): BaseViewHolder {
        val adapterBinding = ChoiceListItemBinding.inflate(
            LayoutInflater.from(viewGroup.context),
            viewGroup, false
        )

        return ChoiceListViewHolder(adapterBinding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int {
        return questionItems!!.size
    }

    inner class ChoiceListViewHolder(private val adapterBinding: ChoiceListItemBinding) :
        BaseViewHolder(adapterBinding.root) {

        private var questionItemViewModel: ChoicesItemViewModel? = null

        override fun onBind(position: Int) {
            if (questionItems != null) {

                if (questionItems.size > 0) {
                    val choiceListItem = questionItems[position]
                    questionItemViewModel = ChoicesItemViewModel(choiceListItem)
                    adapterBinding.viewModel = questionItemViewModel

                }
            }
        }


    }
}
