package com.mvp.omar.mvp_example.SecondActivity.Presenter;

import com.mvp.omar.mvp_example.SecondActivity.Interactor.ItemInteractor;
import com.mvp.omar.mvp_example.SecondActivity.Interactor.ItemInteractorImplementation;
import com.mvp.omar.mvp_example.SecondActivity.View.ItemsView;

import java.util.List;

public class ItemPresenterImplementation implements ItemPresenter , ItemInteractorImplementation.onFinishedListener {

    ItemsView itemsView;
    ItemInteractor itemInteractor;

    public ItemPresenterImplementation(ItemsView itemsView) {
        this.itemsView = itemsView;
        itemInteractor = new ItemInteractorImplementation();
        itemInteractor.findItems(this);
    }

    @Override
    public void onResume() {
        itemsView.showProgressBar();
        itemInteractor.findItems(this);
    }

    @Override
    public void onItemClicked(int position) {

        itemsView.showMessage("Item "+ position + " Clicked");
    }

    @Override
    public void onFinish(List<String> items) {
        itemsView.setItems(items);
        itemsView.hideProgressBar();
    }
}
