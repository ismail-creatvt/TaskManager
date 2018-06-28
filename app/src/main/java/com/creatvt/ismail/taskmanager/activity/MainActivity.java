package com.creatvt.ismail.taskmanager.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.creatvt.ismail.taskmanager.R;
import com.creatvt.ismail.taskmanager.adapter.TaskAdapter;
import com.creatvt.ismail.taskmanager.data.Task;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int ADD_TASK = 1;
    FloatingActionButton addTask;
    TaskAdapter taskAdapter;
    TextView noTask;
    List<Task> tasks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        noTask = findViewById(R.id.no_task);
        addTask = findViewById(R.id.add_task);
        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddTaskActivity.class);
                startActivityForResult(intent,ADD_TASK);
            }
        });

        RecyclerView rvTaskList = findViewById(R.id.task_list);

        tasks = new ArrayList<>();

        taskAdapter = new TaskAdapter(tasks);

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == ADD_TASK && resultCode == RESULT_OK){
            String title = data.getStringExtra("title");
            String date = data.getStringExtra("date");
            String time = data.getStringExtra("time");

            tasks.add(new Task(title,date,time, Task.Status.NOT_DONE));
            if(tasks.size()>0)
                noTask.setVisibility(View.GONE);
            taskAdapter.notifyDataSetChanged();
        }
    }
}
