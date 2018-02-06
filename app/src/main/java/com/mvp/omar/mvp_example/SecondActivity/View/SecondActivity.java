package com.mvp.omar.mvp_example.SecondActivity.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mvp.omar.mvp_example.R;
import com.mvp.omar.mvp_example.SecondActivity.Presenter.ItemPresenter;
import com.mvp.omar.mvp_example.SecondActivity.Presenter.ItemPresenterImplementation;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class SecondActivity extends AppCompatActivity implements ItemsView {

    //FindingProgressbar
    @BindView(R.id.pbLoadingItems)
    ProgressBar progressBar;

    //FindingListView
    @BindView(R.id.lvItems)
    ListView listView;

    //Creating object from presenter
    ItemPresenter itemPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ButterKnife.bind(this);
        itemPresenter = new ItemPresenterImplementation(this);
    }

    @Override
    protected void onResume() {
        itemPresenter.onResume();
        super.onResume();
    }




        @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
        listView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
        listView.setVisibility(View.VISIBLE);

    }

    @Override
    public void setItems(List<String> items) {
    listView.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1 , items));
    }

    @Override
    public void showMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
    @OnItemClick(R.id.lvItems)
    public void itemClick (int position){
        itemPresenter.onItemClicked(position);
    }
}
