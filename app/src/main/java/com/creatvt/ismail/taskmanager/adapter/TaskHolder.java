package com.creatvt.ismail.taskmanager.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.creatvt.ismail.taskmanager.R;

class TaskHolder extends RecyclerView.ViewHolder{
    TextView taskTitle,taskDate,taskTime;
    ProgressBar taskProgress;
    CardView task;
    public TaskHolder(View view) {
        super(view);
        taskTitle = view.findViewById(R.id.task_title);
        taskTime = view.findViewById(R.id.task_time);
        taskDate = view.findViewById(R.id.task_date);
        taskProgress = view.findViewById(R.id.task_progress);
        task = view.findViewById(R.id.task);

    }
}
