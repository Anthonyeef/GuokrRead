package io.github.anthonyeef.guokrread.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import io.github.anthonyeef.guokrread.R;
import io.github.anthonyeef.guokrread.model.result;

/**
 * Created by anthonyeef on 12/7/15.
 */
public class ArticleRecyclerAdapter extends
        RecyclerView.Adapter<ArticleRecyclerAdapter.ViewHolder> {

    private Context mContext;
    private List<result> mResults;

    public ArticleRecyclerAdapter(Context context, List<result> results) {
        this.mContext = context;
        this.mResults = results;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final SimpleDraweeView mItemImage;
        public final TextView mTitle;
        public final TextView mAuthor;
        public final TextView mReply;
        public final TextView mSource;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mItemImage = (SimpleDraweeView) view.findViewById(R.id.head_img_view);
            mTitle = (TextView) view.findViewById(R.id.feed_title);
            mAuthor = (TextView) view.findViewById(R.id.feed_author_name);
            mReply = (TextView) view.findViewById(R.id.feed_replies_count);
            mSource = (TextView) view.findViewById(R.id.item_source);
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.feed_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        result result = mResults.get(position);

        holder.mTitle.setText(result.getTitle());
        holder.mAuthor.setText(result.getAuthor());
//        holder.mReply.setText(result.getReplies_count());
        holder.mReply.setText(Long.toString(result.getReplies_count()));
        holder.mSource.setText(result.getSource_name());

        Uri imageUri = Uri.parse(result.getHeadline_img());
        holder.mItemImage.setImageURI(imageUri);

    }


    public void add(int position, result item) {
        mResults.add(position, item);
        notifyItemInserted(position);
    }

    @Override
    public int getItemCount() {
        return (null != mResults ? mResults.size() : 0);
//        return mResults.size();
    }
}