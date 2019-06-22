package com.topnews.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.topnews.databinding.RowHeadlineBinding;
import com.topnews.service.model.Article;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

public class NewsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Article> articles;
    private LayoutInflater layoutInflater;

    public NewsListAdapter(List<Article> articles) {
        this.articles = articles;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (null == layoutInflater)
            layoutInflater = LayoutInflater.from(parent.getContext());

        return new HeadlingViewHolder(RowHeadlineBinding.inflate(layoutInflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        final Article item = articles.get(position);

        HeadlingViewHolder headlingViewHolder = (HeadlingViewHolder) holder;
        headlingViewHolder.bind(item);

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class HeadlingViewHolder extends RecyclerView.ViewHolder {

        private final RowHeadlineBinding binding;

        HeadlingViewHolder(RowHeadlineBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(final Article item) {

            binding.setVariable(BR.article, item);
        }

    }

}
