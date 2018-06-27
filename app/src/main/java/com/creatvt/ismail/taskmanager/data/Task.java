package com.creatvt.ismail.taskmanager.data;

public class Task {
    public String title;
    public String date;
    public String time;
    public Status status;
    public enum Status{
        DONE,NOT_DONE,DOING
    }

    public Task(String title, String date, String time, Status status) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.status = status;
    }
}
