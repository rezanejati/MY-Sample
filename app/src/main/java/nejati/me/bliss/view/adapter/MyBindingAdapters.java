package nejati.me.bliss.view.adapter;

import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import java.util.List;

import nejati.me.bliss.view.activity.detail.DetailQuestionNavigator;
import nejati.me.bliss.viewModel.questionList.QuestionViewModel;
import nejati.me.service.model.questionsModel.response.Choice;
import nejati.me.service.model.questionsModel.response.QuestionsResponse;

public class MyBindingAdapters
{
    @BindingAdapter({"bind:recyclerAdapter","bind:itemClick"})
    public static void addItems(RecyclerView recyclerView, List<QuestionsResponse> items, QuestionViewModel questionViewModel)
    {
        if (recyclerView.getAdapter()==null){
            QuestionListAdapter adapter = new QuestionListAdapter(items,questionViewModel);
            recyclerView.setAdapter(adapter);
        }else{
            recyclerView.getAdapter().notifyDataSetChanged();
        }


    }
    @BindingAdapter("questionImage")
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl).apply(new RequestOptions().circleCrop())
                .into(view);
    }

    @BindingAdapter("bind:choiceAdapter")
    public static void addChoice(RecyclerView recyclerView, List<Choice> items)
    {
        if (recyclerView.getAdapter()==null){
            ChoiceListAdapter adapter = new ChoiceListAdapter(items);
            recyclerView.setAdapter(adapter);
        }else{
            recyclerView.getAdapter().notifyDataSetChanged();
        }


    }

}
