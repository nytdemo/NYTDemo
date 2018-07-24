package nytimes.siddarth.com.nytimes.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import nytimes.siddarth.com.nytimes.R;
import nytimes.siddarth.com.nytimes.utils.NewsListAdapter;
import nytimes.siddarth.com.nytimes.utils.Constants;
import nytimes.siddarth.com.nytimes.model.NewsData;
import nytimes.siddarth.com.nytimes.databinding.ActivityNewsdataListBinding;
import nytimes.siddarth.com.nytimes.utils.OnNewsClickedListener;
import nytimes.siddarth.com.nytimes.viewmodel.NewsViewModel;

public class NewsListActivity extends AppCompatActivity implements OnNewsClickedListener {


    private boolean mTwoPane;
    private ArrayList<NewsData> list;


    private NewsViewModel viewModel;
    private ActivityNewsdataListBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_newsdata_list);
        viewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
        viewModel.init();
        setSupportActionBar(mBinding.toolbar);
        mBinding.toolbar.setTitle(getTitle());
        mBinding.progress.pbrActivityHome.setVisibility(View.VISIBLE);


        if (findViewById(R.id.newsdata_detail_container) != null) {

            mTwoPane = true;
        }

        View recyclerView = findViewById(R.id.newsdata_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {

        list = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        final NewsListAdapter adapter = new NewsListAdapter(this,list, mTwoPane);
        recyclerView.setAdapter(adapter);
        adapter.setOnNewsClickedListener(this);
        viewModel.getNewsData().observe(this, new Observer<List<NewsData>>() {
            @Override
            public void onChanged(@Nullable List<NewsData> newsData) {
                if (newsData!=null) {
                    list.clear();
                    list.addAll(newsData);
                    mBinding.progress.pbrActivityHome.setVisibility(View.GONE);
                    adapter.notifyDataSetChanged();

                }else {
                    Toast.makeText(NewsListActivity.this, "Failure ", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public void onNewsClicked(int position) {
        if (mTwoPane) {
            Bundle arguments = new Bundle();
            arguments.putParcelable(Constants.ITEM_ID, list.get(position));
            NewsDetailFragment fragment = new NewsDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.newsdata_detail_container, fragment)
                    .commit();
        } else {
            Intent intent = new Intent(this, NewsDetailActivity.class);
            intent.putExtra(Constants.ITEM_ID, list.get(position));
            startActivity(intent);
        }

    }



}
