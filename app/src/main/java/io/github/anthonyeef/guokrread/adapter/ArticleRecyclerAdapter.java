package io.github.anthonyeef.guokrread.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

import io.github.anthonyeef.guokrread.R;
import io.github.anthonyeef.guokrread.model.Post;

/**
 * Created by anthonyeef on 12/7/15.
 */
public class ArticleRecyclerAdapter extends
        RecyclerView.Adapter<ArticleRecyclerAdapter.ViewHolder> {

    private ArrayList<Post> mPosts;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        public final SimpleDraweeView mItemImage;
        public final TextView mTitle;
        public final TextView mAuthor;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            mItemImage = (SimpleDraweeView) view.findViewById(R.id.head_img_view);
            mTitle = (TextView) view.findViewById(R.id.feed_title);
            mAuthor = (TextView) view.findViewById(R.id.feed_author_name);
        }

    }


    public void add(int position, Post item) {
        mPosts.add(position, item);
        notifyItemInserted(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.feed_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Post post = mPosts.get(position);

        holder.mTitle.setText(post.getTitle());
        holder.mAuthor.setText(post.getAuthor());

        Uri imageUri = Uri.parse(post.getHeadline_img());
        holder.mItemImage.setImageURI(imageUri);

    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }
}
