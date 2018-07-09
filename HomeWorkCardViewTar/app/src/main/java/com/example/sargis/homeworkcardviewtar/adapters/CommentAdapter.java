package com.example.sargis.homeworkcardviewtar.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sargis.homeworkcardviewtar.models.CommentModel;
import com.example.sargis.homeworkcardviewtar.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {
    private Context context;
    private List<CommentModel> list;

    public CommentAdapter(Context context, List<CommentModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CommentAdapter.CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        final View view = inflater.inflate(R.layout.comm_item, parent, false);
        return new CommentAdapter.CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentAdapter.CommentViewHolder holder, int position) {
        final CommentModel commentModel = list.get(position);
        holder.textViewTile.setText(commentModel.getCommTitle());
        holder.textViewComm.setText(commentModel.getCommText());
        Picasso.get().load(commentModel.getImageUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class CommentViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textViewTile;
        private TextView textViewComm;

        CommentViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.comment_image_id);
            textViewTile = itemView.findViewById(R.id.comment_title_id);
            textViewComm = itemView.findViewById(R.id.comment_text_id);
        }
    }
}
