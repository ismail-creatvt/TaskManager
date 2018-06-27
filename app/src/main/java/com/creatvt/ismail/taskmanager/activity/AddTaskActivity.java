package com.creatvt.ismail.taskmanager.activity;

import android.app.DatePickerDialog;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.creatvt.ismail.taskmanager.R;

public class AddTaskActivity extends AppCompatActivity {

    TextInputEditText taskTitleInput;
    Button pickDate,pickTime,addTask,cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        taskTitleInput = findViewById(R.id.task_title_input_field);

        pickDate = findViewById(R.id.pick_date);

        pickTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.Builder builder = new DatePickerDialog.Builder(AddTaskActivity.this,R.style.AppTheme);
                DatePickerDialog datePicker = (DatePickerDialog) builder.create();

            }
        });
        pickTime = findViewById(R.id.pick_time);
        addTask = findViewById(R.id.add_task);

        cancel = findViewById(R.id.task_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}
