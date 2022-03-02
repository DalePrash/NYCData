package com.example.nycdata.via_java_mvp.presenter;

import android.content.Context;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nycdata.via_java_mvp.view.NYCMainActivity;
import com.example.rickymortydapr.network.RetroInstance;
import com.example.rickymortydapr.network.RetroService;
import com.example.rickymortydapr.network.StudentData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NYCPresenter extends AppCompatActivity implements NYCContractor.NYCPresenterInterface {
   private static NYCMainActivity mainActivity;
    private Context context;
    public    NYCPresenter(Context context)
    {
        this.context = context;
        mainActivity = new NYCMainActivity();
    }

    @Override
    public void serviceCall(Context context) {
        regularServiceCall();
        /*val md: NYCDatabase = NYCDatabase.getDatabase(this@NYCPagingSource)
        val mdao: NYCDao = md.movieAbs()

        mdao.insert(response)

         */
    }

    @Override
    public void saveData(Context context) {

    }

   static void regularServiceCall() {

       RetroService retroService = RetroInstance.Companion.getRetroInstance().create(RetroService.class);
       //RetroService   retroService = RetroInstance.getRetroInstance().create(RetroService.class);

       Call<List<StudentData>> call = retroService.getDataFromNYCAPI();


       //    Call<StudentData> call = apiService.getTopRatedMovies();

       call.enqueue(new Callback<List<StudentData>>() {
           @Override
           public void onResponse(Call<List<StudentData>> call, Response<List<StudentData>> response) {
   mainActivity.showDetails(response.body());

            //   Log.i("a", "a");






           }

           @Override
           public void onFailure(Call<List<StudentData>> call, Throwable t) {
               Log.i("a", "a");

           }
       });


   } }
