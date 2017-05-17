package com.example.mydiary;

import android.content.Context;

/**
 * Created by kth919 on 2017-05-14.
 */

public class MemoViewModel   {

    private MemoModel memoModel;
    private Context context;

    public MemoViewModel(MemoModel memoModel) {
        this.memoModel = memoModel;
    }

    public String getMemo(){
        return memoModel.getMemo();

    }
}
