package com.example.sargis.homeworkcardviewtar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.example.sargis.homeworkcardviewtar.adapters.ImageAdapter;
import com.example.sargis.homeworkcardviewtar.dataProvider.ImageDataProvider;


public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        final RecyclerView imageListView = findViewById(R.id.image_list_Id);
        imageListView.setHasFixedSize(true);
        final LinearLayoutManager manager = new LinearLayoutManager(this);
        imageListView.setLayoutManager(manager);
        final ImageAdapter imageAdapter =
                new ImageAdapter(this, ImageDataProvider.getlistItem());
        imageListView.setAdapter(imageAdapter);
    }
}
