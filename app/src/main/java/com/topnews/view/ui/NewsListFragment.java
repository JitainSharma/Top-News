package com.topnews.view.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.topnews.R;
import com.topnews.databinding.FragmentNewslistBinding;
import com.topnews.service.model.Article;
import com.topnews.view.adapter.NewsListAdapter;
import com.topnews.viewmodel.NewsListViewModel;
import com.topnews.viewmodel.ViewModelProviderFactory;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import dagger.android.support.DaggerFragment;

public class NewsListFragment extends DaggerFragment {

    @Inject
    ViewModelProviderFactory providerFactory;

    private FragmentNewslistBinding binding;

    private NewsListAdapter newsListAdapter;
    private List<Article> articleList = new ArrayList<>(0);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_newslist, container, false);
        binding.setLifecycleOwner(this);

        NewsListViewModel viewModel = ViewModelProviders.of(this, providerFactory).get(NewsListViewModel.class);
        binding.setViewModel(viewModel);

        DividerItemDecoration horizontalDecoration = new DividerItemDecoration(binding.rvArticles.getContext(),
                DividerItemDecoration.VERTICAL);
        Drawable horizontalDivider = ContextCompat.getDrawable(getContext(), R.drawable.horizontal_divider);
        horizontalDecoration.setDrawable(horizontalDivider);
        binding.rvArticles.addItemDecoration(horizontalDecoration);

        newsListAdapter = new NewsListAdapter(articleList);
        binding.rvArticles.setAdapter(newsListAdapter);

        binding.getViewModel().getDataLive().observe(this, articles -> {

            if (null != articles && !articles.isEmpty()) {

                articleList.addAll(0, articles);
                newsListAdapter.notifyDataSetChanged();

            }

        });

        binding.getViewModel().fetchTopNews();
        return binding.getRoot();
    }

}
