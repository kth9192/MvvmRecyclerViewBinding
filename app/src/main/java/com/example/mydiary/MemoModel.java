package com.example.mydiary;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.Observable;

/**
 * Created by kth919 on 2017-05-13.
 */

public class MemoModel extends BaseObservable {

    public String memo;

    public MemoModel(String memo){
        this.memo = memo;
    }

    @Bindable
    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }


}
