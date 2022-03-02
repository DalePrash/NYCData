package com.example.nycdata.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.example.nycdata.R;
import com.example.nycdata.via_java_mvp.view.NYCMainActivity;
import com.example.rickymortydapr.network.StudentData;

public class NYCRecyclerAdapter extends RecyclerView.Adapter<NYCRecyclerAdapter.NYCDataHolder> {

    private  static List<StudentData> studData;
    private Context context;

    public NYCRecyclerAdapter(List<StudentData> data, Context context) {
        this.studData = data;
        this.context = context;
    }

    @NonNull
    @Override
    public NYCDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detail, parent, false);
        return new NYCDataHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull NYCDataHolder holder, int position) {
        holder.textschoolName.setText(studData.get(position).getSchool_name());
    }
    @Override
    public int getItemCount() {
        return studData.size();
    }
    public static class NYCDataHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Context context;
        TextView textschoolName;
        public NYCDataHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            textschoolName = itemView.findViewById(R.id.textschoolName);

        }
        @Override
        public void onClick(View view) {
            NYCMainActivity x = new NYCMainActivity(view.getContext() );
            x.moveToDetailActivity(getLayoutPosition(),studData);
        }
    }

    public interface DataClickListener {
        void onItemClick(int position, int layoutPosition, View v);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        context = recyclerView.getContext();
    }
}
