package com.example.nycdata.via_kotlin_paging_mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nycdata.R
import com.example.nycdata.via_kotlin_paging_mvvm.viewmodel.NYC_DATA_VIEW_MODEL
import com.example.rickymortydapr.NYCPagingAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collectLatest

class NYC_DATA_PAGING_MAIN_Activity : AppCompatActivity() {

    lateinit var NYCPagingAdapter: NYCPagingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@NYC_DATA_PAGING_MAIN_Activity)
            val decoration  = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            NYCPagingAdapter = NYCPagingAdapter()
            adapter = NYCPagingAdapter

        }
    }

    private fun initViewModel() {
        val viewModel = ViewModelProvider(this).get(NYC_DATA_VIEW_MODEL::class.java)
        lifecycleScope.launchWhenCreated {
            viewModel.getListData().collectLatest {
                NYCPagingAdapter.submitData(it)
            }
        }
    }
}
