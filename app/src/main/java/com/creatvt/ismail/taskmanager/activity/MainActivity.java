package com.creatvt.ismail.taskmanager.activity;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.creatvt.ismail.taskmanager.R;
import com.creatvt.ismail.taskmanager.adapter.TaskAdapter;
import com.creatvt.ismail.taskmanager.data.Task;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton addTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addTask = findViewById(R.id.add_task);
        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        RecyclerView rvTaskList = findViewById(R.id.task_list);

        List<Task> tasks = new ArrayList<>();

        tasks.add(new Task("Task1","12 Jan 2017","12:00 AM", Task.Status.DONE));
        tasks.add(new Task("Task1","12 Jan 2017","12:00 AM", Task.Status.NOT_DONE));
        tasks.add(new Task("Task1","12 Jan 2017","12:00 AM", Task.Status.DOING));
        tasks.add(new Task("Task1","12 Jan 2017","12:00 AM", Task.Status.DONE));
        tasks.add(new Task("Task1","12 Jan 2017","12:00 AM", Task.Status.DONE));
        tasks.add(new Task("Task1","12 Jan 2017","12:00 AM", Task.Status.DONE));


        TaskAdapter taskAdapter = new TaskAdapter(tasks);

        rvTaskList.setAdapter(taskAdapter);
        rvTaskList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.search:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
