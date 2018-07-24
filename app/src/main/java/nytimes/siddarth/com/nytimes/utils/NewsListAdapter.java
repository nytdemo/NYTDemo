package nytimes.siddarth.com.nytimes.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;
import nytimes.siddarth.com.nytimes.model.NewsData;
import nytimes.siddarth.com.nytimes.databinding.NewsdataListContentBinding;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ViewHolder> {

    private Context context;
    private List<NewsData> data;
    private boolean mTwoPane;

    private OnNewsClickedListener listener;


    public NewsListAdapter(Context context,List<NewsData> liveData,boolean mTwoPane){

        this.context = context;
        this.data = liveData;
        this.mTwoPane = mTwoPane;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());
        NewsdataListContentBinding itemBinding =
                NewsdataListContentBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(itemBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.bind(data.get(position),position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

         NewsdataListContentBinding mBinding;

        ViewHolder(NewsdataListContentBinding mBinding) {
            super(mBinding.getRoot());
            this.mBinding = mBinding;

        }

        private void bind(Object obj,final int position) {
            if (obj instanceof NewsData) {
                NewsData data = (NewsData) obj;
                if (!TextUtils.isEmpty(data.getMedia().get(0).getMediaMetaData().get(0).getUrl())){
                    Picasso.with(context)
                            .load(data.getMedia().get(0).getMediaMetaData().get(0).getUrl())
                            .transform(new CropCircleTransformation())
                            .into(mBinding.image);
                }


                mBinding.title.setText(data.getTitle());
                mBinding.content.setText(data.getByline());
                mBinding.time.setText(data.getPublishedDate());
                mBinding.parent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onNewsClicked(position);
                        }
                    }
                });
            }
        }
    }

    public void setOnNewsClickedListener(OnNewsClickedListener listener){

        this.listener = listener;
    }
}
