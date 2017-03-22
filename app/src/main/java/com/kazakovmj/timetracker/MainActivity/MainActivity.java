package com.kazakovmj.timetracker.MainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.kazakovmj.timetracker.AddTaskActivity;
import com.kazakovmj.timetracker.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static private final int REQUEST_ADD_NEW_TASK = 0;

    private ListView listViewTasks;
    private List<Task> data = new ArrayList<Task>(){
        {
            add(new Task("English", 1));
            add(new Task("Deutsch", 50));
            add(new Task("Android", 520));
            add(new Task("Java", 50));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents() {
        initToolbar();
        initFloatingActionButton();
        initListView();
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initFloatingActionButton() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
                startActivityForResult(intent, REQUEST_ADD_NEW_TASK);
            }
        });
    }

    private void initListView() {
        listViewTasks = (ListView) findViewById(R.id.content_main_list_view_tasks);
        listViewTasks.setAdapter(new TaskArrayAdapter(this, R.layout.task_list_item_layout, data ));

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_ADD_NEW_TASK)
        {
            if (resultCode == RESULT_CANCELED)
                Toast.makeText(this, "!!!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
