package com.guiying.module.girls.main;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.guiying.module.girls.R;
import com.guiying.module.girls.data.bean.Movie;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

public class MovieAdapter extends RecyclerArrayAdapter<Movie> {

    public OnMyItemClickListener mOnItemClickListener;

    public MovieAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new GirlsViewHolder(parent);
    }

    @Override
    public void OnBindViewHolder(final BaseViewHolder holder, final int position) {
        super.OnBindViewHolder(holder, position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(position, holder);
                }
            }
        });
    }

    private class GirlsViewHolder extends BaseViewHolder<Movie> {

        private ImageView image;

        private GirlsViewHolder(ViewGroup parent) {
            super(parent, R.layout.item_movie);
            image = $(R.id.girl_img);
        }

        @Override
        public void setData(Movie data) {
            super.setData(data);
            Glide.with(getContext())
                    .load(R.drawable.timg_movie)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(image);
        }
    }

    public interface OnMyItemClickListener {
        void onItemClick(int position, BaseViewHolder holder);
    }

    public void setOnMyItemClickListener(OnMyItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}
