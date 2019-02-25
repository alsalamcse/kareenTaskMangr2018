package com.owayed.kareen.kareentaskmangr2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.owayed.kareen.kareentaskmangr2018.datePicker.TaskAdopter;

public class ShowAllTasksActivity extends AppCompatActivity {
    private ListView IvAnimal;
    private TaskAdopter TaskAdopter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_tasks);
    }
}
