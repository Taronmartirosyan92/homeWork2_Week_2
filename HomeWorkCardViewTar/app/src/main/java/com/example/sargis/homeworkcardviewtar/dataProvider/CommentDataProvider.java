package com.example.sargis.homeworkcardviewtar.dataProvider;

import com.example.sargis.homeworkcardviewtar.models.CommentModel;

import java.util.ArrayList;
import java.util.List;

public class CommentDataProvider {
    public static List<CommentModel> listItem = new ArrayList<>();

    public static List<CommentModel> getCommLisItem() {
        return listItem;
    }

  /* protected static int getListSize() {

        return listItem.size();
    }
    */
}
