package com.example.imagessubredditviewer.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.imageloader.ImageLoader;
import com.example.imagessubredditviewer.R;
import com.example.imagessubredditviewer.model.ChildrenItem;

import java.util.List;

public class RedditAdapter extends RecyclerView.Adapter<RedditAdapter.ViewHolder> {

    private static final String TAG = "RedditAdapter";
    private List<ChildrenItem> list;
    private ItemClickListener listener;

    public RedditAdapter(ItemClickListener listener) {
        this.listener = listener;
    }

    public void setList(List<ChildrenItem> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        ImageLoader.get(viewHolder.imageView.getContext())
                .loadUrl(list.get(i).getData().getUrl())
                .target(viewHolder.imageView)
                .execute();
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.imageView);
        }

        @Override
        public void onClick(View v) {
        }
    }

    public interface ItemClickListener {

        void onItemClick(ChildrenItem item);
    }
}
