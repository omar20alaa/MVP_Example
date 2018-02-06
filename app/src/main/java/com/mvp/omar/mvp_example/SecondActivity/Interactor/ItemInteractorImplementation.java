package com.mvp.omar.mvp_example.SecondActivity.Interactor;


import android.os.Handler;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

public class ItemInteractorImplementation implements ItemInteractor {


    @Override
    public void findItems(final onFinishedListener onFinishedListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onFinishedListener.onFinish(createArraylist());
            }
        }, 2000);
    }

    private List<String> createArraylist() {

        return Arrays.asList(
                "One",
                "Two",
                "Three",
                "Four",
                "Five",
                "Six",
                "Seven",
                "Eight",
                "Nine",
                "Ten"
                );
    }
}
