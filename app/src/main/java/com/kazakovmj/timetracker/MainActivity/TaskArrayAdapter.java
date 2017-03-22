package com.kazakovmj.timetracker.MainActivity;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kazakovmj.timetracker.R;

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Макс on 15.03.2017.
 */

public class TaskArrayAdapter extends ArrayAdapter<Task> {

    private List<Task> list;
    private Context context;

    public TaskArrayAdapter(Context context, int resource, List<Task> objects) {
        super(context, resource, objects);
        this.context = context;
        list = objects;
    }



    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final View view = LayoutInflater.from(context).inflate(R.layout.task_list_item_layout, parent, false);
        final TextView name = (TextView) view.findViewById(R.id.task_list_item_layout_text_view_name);
        final TextView time = (TextView) view.findViewById(R.id.task_list_item_layout_text_view_time);
        final ProgressBar progress = (ProgressBar) view.findViewById(R.id.task_list_item_layout_progress_bar_progress);
        Button start = (Button) view.findViewById(R.id.task_list_item_layout_button_start);

        final Task task = list.get(position);

        name.setText(task.getName());
        String timeStr = task.getDoneSeconds() + "/" + task.getSeconds();
        time.setText(timeStr);
        progress.setProgress((int)((double) task.getDoneSeconds() / task.getSeconds() * 100));

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                task.setDoneSeconds(task.getDoneSeconds() + 1);
                progress.setProgress((int) ((double) task.getDoneSeconds() / task.getSeconds() * 100));
                String timeStr = task.getDoneSeconds() + "/" + task.getSeconds();
                time.setText(timeStr);
                handler.postDelayed(this, 1000);
            }
        };

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!task.isRunning()) {
                    task.setRunning(true);
                    handler.postDelayed(runnable, 1000);
                }
                else {
                    task.setRunning(false);
                    handler.removeCallbacks(runnable);
                }
            }
        });


        return view;
    }
}
