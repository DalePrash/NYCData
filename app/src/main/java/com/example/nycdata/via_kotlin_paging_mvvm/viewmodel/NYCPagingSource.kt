package com.example.nycdata.via_kotlin_paging_mvvm.viewmodel

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickymortydapr.network.RetroService
import com.example.rickymortydapr.network.StudentData

class NYCPagingSource(val apiService: RetroService): PagingSource<Int, StudentData>() {
    override fun getRefreshKey(state: PagingState<Int, StudentData>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, StudentData> {
        return try {
            val response = apiService.getDataFromAPI()
            LoadResult.Page(
                data = response,
                prevKey = null,
                nextKey = 5
            )
        }
        catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}