package com.kazakovmj.timetracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class AddTaskActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextHours;
    private EditText editTextMinute;
    private Button buttonAdd;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        initComponents();
    }

    private void initComponents() {
        initToolbar();
        initEditText();
        initButtonAdd();
        initProgressBar();
    }

    private void initProgressBar() {
        progress = (ProgressBar) findViewById(R.id.content_add_task_progress_bar_progress);
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initEditText() {
        editTextName = (EditText) findViewById(R.id.content_add_task_edit_text_name);
        editTextHours = (EditText) findViewById(R.id.content_add_task_edit_text_hours);
        editTextMinute = (EditText) findViewById(R.id.content_add_task_edit_text_minutes);
    }

    private void initButtonAdd() {
        buttonAdd = (Button) findViewById(R.id.content_add_task_button_add);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress.incrementProgressBy(1);
            }
        });
    }



}
