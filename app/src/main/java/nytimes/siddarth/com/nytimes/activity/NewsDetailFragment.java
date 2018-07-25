package nytimes.siddarth.com.nytimes.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import nytimes.siddarth.com.nytimes.R;
import nytimes.siddarth.com.nytimes.utils.Constants;
import nytimes.siddarth.com.nytimes.model.NewsData;
import nytimes.siddarth.com.nytimes.databinding.NewsdataDetailBinding;



public class NewsDetailFragment extends Fragment {


    private NewsData data;


    public NewsDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getArguments()!=null && getArguments().containsKey(Constants.ITEM_ID)) {

            data = getArguments().getParcelable(Constants.ITEM_ID);

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(data.getTitle());
                ImageView imageView = appBarLayout.findViewById(R.id.image);

            Picasso.with(getActivity()).load(data.getMedia().get(0).getMediaMetaData().get(0).getUrl())
                    .into(imageView);
            }

            



        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        NewsdataDetailBinding mBnding = DataBindingUtil.inflate(getLayoutInflater(),R.layout.newsdata_detail,container,false);

        if (data != null) {
            mBnding.newsdataDetail.setText(data.getAbst());
        }

        return mBnding.getRoot();
    }
}
