package com.example.nycdata.via_kotlin_paging_mvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.rickymortydapr.network.RetroInstance
import com.example.rickymortydapr.network.RetroService
import com.example.rickymortydapr.network.StudentData
import kotlinx.coroutines.flow.Flow

public class NYC_DATA_VIEW_MODEL: ViewModel() {
    lateinit var retroService: RetroService
    init {
           retroService = RetroInstance.getRetroInstance().create(RetroService::class.java)
    }
    fun getListData(): Flow<PagingData<StudentData>> {
        return Pager (config = PagingConfig(pageSize = 34, maxSize = 200),
        pagingSourceFactory = { NYCPagingSource(retroService) }).flow.cachedIn(viewModelScope)
    }
}