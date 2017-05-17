package com.example.mydiary;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mydiary.databinding.ItemRecycleBinding;

import java.util.List;

/**
 * Created by kth919 on 2017-05-12.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.BindingHolder>{

    private static String TAG = RecyclerAdapter.class.getName();

    private List<MemoModel> mMemoModels;
    private Context context;

    public RecyclerAdapter(List<MemoModel> memoModel){
        mMemoModels = memoModel;

    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle, parent,  false);

        return new BindingHolder(v);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {

        MemoModel model = mMemoModels.get(position);
        holder.getItemBinding().setMemoItem(model);
        holder.getItemBinding().executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return mMemoModels.size();
    }

    class BindingHolder extends RecyclerView.ViewHolder{

        private ItemRecycleBinding itemBinding;

        public BindingHolder(View itemView) {

            super(itemView);
            itemBinding = DataBindingUtil.bind(itemView);
//            itemBinding.setMemoItem(new MemoViewModel());
        }

        public ItemRecycleBinding getItemBinding(){ return itemBinding;}

    }

}
