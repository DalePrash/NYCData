package com.example.rickymortydapr.network

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

//public data class StudentDataList(val results: List<StudentData>)
//
//@Entity(tableName = "mov_table")


data class StudentData(
    @SerializedName("dbn") @NonNull  val dbn: String?,
@SerializedName("school_name") @NonNull val school_name: String?,
    @SerializedName("num_of_sat_test_takers") @NonNull val sat: String?
    )

// @SerializedName("school_name") @NonNull val school_name: String?, @PrimaryKey(autoGenerate = false)val count: Int?)
//data class StudentData(val dbn: String?, val school_name: String?, val num_of_sat_test_takers: Int?, val sat_critical_reading_avg_score:Int?)
//{"dbn":"01M292","school_name":"HENRY STREET SCHOOL FOR INTERNATIONAL STUDIES",
// "num_of_sat_test_takers":"29","sat_critical_reading_avg_score":"355"

@Entity(tableName = "nyc_table")
data class StudentFUllData(
    @SerializedName("dbn") @NonNull  val dbn: String?,
    @SerializedName("school_name") @NonNull val school_name: String?,
    @SerializedName("num_of_sat_test_takers") @NonNull val sat: String?,@PrimaryKey(autoGenerate = false)
    @SerializedName("sat_critical_reading_avg_score") @NonNull val avg: Int?

)