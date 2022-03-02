package com.example.nycdata.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import com.example.rickymortydapr.network.StudentFUllData;

import java.util.List;

import retrofit2.Call;

// TODO@Dao
public interface NYCDao {

    @Query("SELECT * FROM nyc_table")
    List<StudentFUllData> getAlphabetizedWords();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Call<StudentFUllData> studentDataList);


    @Delete
    void delete(StudentFUllData nTitle);

    @Query("DELETE FROM nyc_table")
    void deleteAll();

    // @RawQuery("SELECT * FROM news_table")






}
