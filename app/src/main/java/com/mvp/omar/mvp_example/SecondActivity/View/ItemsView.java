package com.mvp.omar.mvp_example.SecondActivity.View;


import java.util.List;

public interface ItemsView {

    void showProgressBar();

    void hideProgressBar();

    void setItems(List<String> items);

    void showMessage(String s);

}
