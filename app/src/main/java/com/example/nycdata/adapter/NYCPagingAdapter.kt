package com.example.rickymortydapr

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nycdata.R
import com.example.rickymortydapr.network.StudentData

class NYCPagingAdapter(): PagingDataAdapter<StudentData, NYCPagingAdapter.MyViewHolder>(DiffUtilCallBack()) {

    override fun onBindViewHolder(holder: NYCPagingAdapter.MyViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NYCPagingAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.activity_detail, parent, false)
        return MyViewHolder(inflater)
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textschoolName: TextView = view.findViewById(R.id.textschoolName)
        fun bind(data: StudentData) {
            textschoolName.text = data.school_name
        }
    }
    class DiffUtilCallBack: DiffUtil.ItemCallback<StudentData>() {
        override fun areItemsTheSame(oldItem: StudentData, newItem: StudentData): Boolean {
           return oldItem.dbn == newItem.dbn
        }
        override fun areContentsTheSame(oldItem: StudentData, newItem: StudentData): Boolean {
            return oldItem.dbn == newItem.dbn
                    && oldItem.school_name == newItem.school_name
        }
    }

}