package com.creatvt.ismail.taskmanager.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.creatvt.ismail.taskmanager.R;
import com.creatvt.ismail.taskmanager.data.Task;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskHolder>{

    List<Task> taskList;
    public TaskAdapter(List<Task> taskList){
        this.taskList = taskList;
    }

    @Override
    public TaskHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item,parent,false);
        return new TaskHolder(view);
    }

    @Override
    public void onBindViewHolder(final TaskHolder holder, int position) {
        Task task = taskList.get(position);
        int progress;
        switch (task.status){
            case DONE:
                progress =100;
                break;
            case DOING:
                progress=50;
                break;
            case NOT_DONE:
                progress=0;
                break;
            default:
                progress=0;
        }
        holder.taskTitle.setText(task.title);
        holder.taskDate.setText(task.date);
        holder.taskTime.setText(task.time);
        holder.taskProgress.setProgress(progress);
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }
}
