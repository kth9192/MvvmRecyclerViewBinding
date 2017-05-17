package com.example.mydiary;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mydiary.databinding.TabFragment1Binding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kth919 on 2017-05-06.
 */

public class TabFragment1 extends Fragment{

    TabFragment1Binding tab1_binding;
    private RecyclerView recyclerView;

    private Context context;
    private List<MemoModel> memoModels = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        tab1_binding = DataBindingUtil.inflate(inflater, R.layout.tab_fragment_1, container, false);
        tab1_binding.setTab1(this);
        View view = tab1_binding.getRoot();

        recyclerView = tab1_binding.recycler;
        // 모델 데이터 할당
        memoModels.add(new MemoModel("Zz"));
        memoModels.add(new MemoModel("what the.."));

        recyclerView.setAdapter(new RecyclerAdapter(memoModels));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        return view;

    }

}
