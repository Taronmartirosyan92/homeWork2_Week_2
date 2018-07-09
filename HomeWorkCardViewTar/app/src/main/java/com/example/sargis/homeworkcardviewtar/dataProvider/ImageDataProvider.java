package com.example.sargis.homeworkcardviewtar.dataProvider;

import com.example.sargis.homeworkcardviewtar.models.ImageModel;

import java.util.ArrayList;
import java.util.List;

public class ImageDataProvider {
    private static List<ImageModel> listItem = new ArrayList<>();

    public static List<ImageModel> getlistItem() {
        listItem.add(new ImageModel("Zinedin Zidan", "http://football365.s3.amazonaws.com/wp/wp-content/uploads/2018/05/f5a2fb1de69a6c_5a2fb1de69aa9.thumb_.jpg"));
        listItem.add(new ImageModel("guf", "http://www.rap.ru/img/news/b/9240.jpg?1506007679"));
        listItem.add(new ImageModel("Basta", "https://upload.wikimedia.org/wikipedia/commons/1/13/Basta_and_Guf_at_Green_Theatre_100721.jpg"));

        return listItem;
    }

    public static ImageModel getImageByPosition(int position) {
        return listItem.get(position);
    }
}
