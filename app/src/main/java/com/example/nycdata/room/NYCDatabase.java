package com.example.nycdata.room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.rickymortydapr.network.StudentFUllData;


// TODO@Database(entities = {StudentFUllData.class}, version = 1, exportSchema = true)
public  abstract class NYCDatabase extends RoomDatabase {

    private static volatile NYCDatabase INSTANCE;

    public   abstract NYCDao nycAbstractDao();

    public static NYCDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (NYCDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            NYCDatabase.class, "nyc_database")
                            .addCallback(sRoomDatabaseCallback)
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }



    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };
    public   void destroyDataBase(){
        INSTANCE = null;
    }



}
