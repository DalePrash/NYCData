package com.example.nycdata.via_java_mvp.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nycdata.R;
import com.example.nycdata.adapter.NYCRecyclerAdapter;
import com.example.nycdata.via_java_mvp.presenter.NYCContractor;
import com.example.nycdata.via_java_mvp.presenter.NYCPresenter;
import com.example.rickymortydapr.network.StudentData;

import java.util.List;

public class NYCMainActivity extends AppCompatActivity  implements NYCContractor.NYCCView, View.OnClickListener {
   NYCPresenter presenter;
  static  RecyclerView recyclerView;
  List<StudentData> movieList;
  NYCRecyclerAdapter adpater ;
  private Context context;

public NYCMainActivity() {
}

    public NYCMainActivity(Context context1)
    {
        this.context = context1;

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
       recyclerView.setOnClickListener(this::onClick);
        presenter = new NYCPresenter(NYCMainActivity.this);
        presenter.serviceCall(this);
        adpater = new NYCRecyclerAdapter(movieList, this);
    }

    @Override
    public void showDetails(List<StudentData> listData) {
      movieList = listData;
        recyclerView.setAdapter(new NYCRecyclerAdapter(listData,NYCMainActivity.this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
}

     @Override
    public void moveToDetailActivity(int position, List<StudentData> list) {
       Intent intentc= new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("dbn",list.get(position).getDbn());
        bundle.putString("sc_name",list.get(position).getSchool_name());
        bundle.putString("sat",list.get(position).getSat());
        intentc.setAction("detail_activity");
        intentc.putExtras(bundle);
        context.startActivity(intentc);
   }
    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onClick(View view) {
        Log.i("a","a");
    }


}






