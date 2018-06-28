package com.creatvt.ismail.taskmanager.activity;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.databinding.adapters.Converters;
import android.icu.text.RelativeDateTimeFormatter;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.style.TtsSpan;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.creatvt.ismail.taskmanager.R;
import com.creatvt.ismail.taskmanager.custom_view.MyDatePicker;
import com.creatvt.ismail.taskmanager.custom_view.MyTimePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class AddTaskActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener {

    TextInputEditText taskTitleInput;
    Button pickDate,pickTime,addTask,cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        taskTitleInput = findViewById(R.id.task_title_input_field);

        pickDate = findViewById(R.id.pick_date);

        pickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatePicker picker = new MyDatePicker();
                picker.show(getSupportFragmentManager(),"date picker");
            }
        });

        pickTime = findViewById(R.id.pick_time);

        pickTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyTimePicker picker = new MyTimePicker();
                picker.show(getSupportFragmentManager(),"time picker");
            }
        });

        addTask = findViewById(R.id.task_add);

        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(taskTitleInput.getText())){
                    showToast("Enter Task Title");
                    return;
                }

                if(pickDate.getText().equals("SELECT DATE")){
                    showToast("Select Date");
                    return;
                }

                if(pickTime.getText().equals("SELECT TIME")){
                    showToast("Select Time");
                    return;
                }

                Intent intent = new Intent();
                intent.putExtra("title",taskTitleInput.getText().toString().trim());
                intent.putExtra("date",pickDate.getText().toString());
                intent.putExtra("time",pickTime.getText().toString());

                setResult(RESULT_OK,intent);
                finish();

            }
        });

        cancel = findViewById(R.id.task_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int date) {
        pickDate.setText(date + "/" + month + "/" + year);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
        SimpleDateFormat from = new SimpleDateFormat("hh:mm");
        SimpleDateFormat to = new SimpleDateFormat("hh:mm aa");
        try {
            String time = to.format(from.parse(hour + ":" + minute));
            pickTime.setText(time);
        }catch (Exception exception){
            Log.i("Exception","Parse Exception");
        }
    }

    public void showToast(String msg){
        Toast toast = Toast.makeText(this,msg,Toast.LENGTH_SHORT);
        View view = getLayoutInflater().inflate(R.layout.custom_toast,null,false);
        ((TextView) view.findViewById(R.id.toast_message)).setText(msg);
        toast.setView(view);
        toast.setGravity(Gravity.TOP,0,100);
        toast.show();
    }
}
