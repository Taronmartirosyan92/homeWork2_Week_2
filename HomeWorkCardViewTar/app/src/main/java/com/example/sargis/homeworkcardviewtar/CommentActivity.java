package com.example.sargis.homeworkcardviewtar;

import android.content.Context;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sargis.homeworkcardviewtar.adapters.CommentAdapter;
import com.example.sargis.homeworkcardviewtar.adapters.ImageAdapter;
import com.example.sargis.homeworkcardviewtar.dataProvider.CommentDataProvider;
import com.example.sargis.homeworkcardviewtar.dataProvider.ImageDataProvider;
import com.example.sargis.homeworkcardviewtar.models.CommentModel;
import com.example.sargis.homeworkcardviewtar.models.ImageModel;
import com.squareup.picasso.Picasso;



public class CommentActivity extends AppCompatActivity {

    private RelativeLayout commentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        final int position = getIntent().getIntExtra(ImageAdapter.IMAGE_POSITION_KEY, 0);
        final ImageModel imageModel = ImageDataProvider.getImageByPosition(position);
        final TextView userTextView = findViewById(R.id.image_title_id);
        userTextView.setText(imageModel.getTitle());
        final ImageView imageView = findViewById(R.id.imageViewByImage_id);
        Picasso.get().load(imageModel.getImageUrl()).into(imageView);




        final EditText commentEditText = findViewById(R.id.ediText_id);

        final RecyclerView commentListView = findViewById(R.id.comment_list_id);
        commentListView.setHasFixedSize(true);
        final LinearLayoutManager managerComm = new LinearLayoutManager(this);
        commentListView.setLayoutManager(managerComm);
        final CommentAdapter commentAdapter = new CommentAdapter(this, CommentDataProvider.getCommLisItem());
        commentListView.setAdapter(commentAdapter);


        final FloatingActionButton floatingActionButton = findViewById(R.id.fab_id);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = commentEditText.getText().toString();
                CommentDataProvider.listItem.add(new CommentModel("http://www.rap.ru/img/news/b/9240.jpg?1506007679", str, "Guf"));
                commentAdapter.notifyDataSetChanged();
                commentEditText.setText(null);
                commentLayout = findViewById(R.id.comment_layout);
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                assert imm != null;
                imm.hideSoftInputFromWindow(commentLayout.getWindowToken(), 0);
                commentListView.scrollToPosition(CommentDataProvider.listItem.size() - 1);
            }
        });
    }
}
