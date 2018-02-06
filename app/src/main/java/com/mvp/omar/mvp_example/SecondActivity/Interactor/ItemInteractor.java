package com.mvp.omar.mvp_example.SecondActivity.Interactor;


import java.util.List;

public interface ItemInteractor {

    interface onFinishedListener{

        void onFinish(List<String> items);

    }

    void findItems(onFinishedListener onFinishedListener);


}
