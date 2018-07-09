package com.example.sargis.homeworkcardviewtar.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sargis.homeworkcardviewtar.CommentActivity;
import com.example.sargis.homeworkcardviewtar.models.ImageModel;
import com.example.sargis.homeworkcardviewtar.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    public static final String IMAGE_POSITION_KEY = "POSITION_KEY";
    private Context context;
    private List<ImageModel> list;
    private int countFib = 0;

    public ImageAdapter(Context context, List<ImageModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ImageAdapter.ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        final View view = inflater.inflate(R.layout.image_item, parent, false);
        return new ImageAdapter.ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ImageAdapter.ImageViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        final ImageModel imageModel = list.get(position);
        Picasso.get().load(imageModel.getImageUrl()).into(holder.imageView);
        holder.imageText.setText(imageModel.getTitle());


        holder.cib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CommentActivity.class);
                intent.putExtra(IMAGE_POSITION_KEY, position);
                context.startActivity(intent);

            }
        });

        holder.fib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++countFib;
                holder.fib.setImageResource(R.drawable.ic_favorite_red_24dp);
                holder.fibCounter.setText(String.valueOf(countFib));

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView imageText;
        private TextView fibCounter;
        private ImageButton cib;
        private ImageButton fib;

        ImageViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView_Id);
            imageText = itemView.findViewById(R.id.image_text_id);
            cib = itemView.findViewById(R.id.image_commentButton_id);
            fib = itemView.findViewById(R.id.image_favorite_id);
            fibCounter = itemView.findViewById(R.id.favorite_counter);
        }
    }
}
