package com.topnews.view.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.topnews.R;
import com.topnews.databinding.FragmentNewsdetailBinding;
import com.topnews.service.model.Article;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

public class NewsDetailFragment extends Fragment {

    private FragmentNewsdetailBinding binding;
    private Article item;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (null == getArguments()) return;

        item = getArguments().getParcelable("Article");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_newsdetail, container, false);
        binding.setLifecycleOwner(this);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(item.getSource().name);

        binding.setArticle(item);

        //Load news image
        if (!TextUtils.isEmpty(item.getUrlToImage()))
            Picasso.get()
                    .load(item.getUrlToImage())
                    .into(binding.ivArticle);

        binding.executePendingBindings();

    }
}
