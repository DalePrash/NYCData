package com.example.nycdata.via_java_mvp.presenter;

import android.content.Context;

import com.example.rickymortydapr.network.StudentData;

import java.util.List;

public interface NYCContractor {
    interface NYCPresenterInterface{
          public void serviceCall(Context context);
        public void saveData(Context context);

    }
    interface NYCCView{
        public void showDetails(List<StudentData> listData);

        public void moveToDetailActivity(int position,List<StudentData> listData);

    }

}
