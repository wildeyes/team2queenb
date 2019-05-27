package com.team2queenb.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.team2queenb.CustomListAdapter;

public class Tasks extends AppCompatActivity {

    String[] tasksNameArray = {"מטלה 11","מטלה 12","מטלה 13","מטלה 14","מטלה 15"};
    ListView tasksListView;
    String[] tasksInfoArray = {
            "פרקים 1-4",
            "פרקים 5-7",
            "פרקים 8-10",
            "פרקים 11-14",
            "פרקים 15-17",
    };


    Integer[] tasksImageArray = {
            R.drawable.mor,
            R.drawable.mor,
            R.drawable.mor,
            R.drawable.mor,
            R.drawable.mor};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        CustomListAdapter whatever = new CustomListAdapter(this, tasksNameArray, tasksInfoArray, tasksImageArray);
        tasksListView = (ListView) findViewById(R.id.listviewTasks);
        tasksListView.setAdapter(whatever);

        tasksListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(Tasks.this, ChatRoom.class);
                String message = tasksNameArray[position];
                intent.putExtra("taskName", message);
                startActivity(intent);
            }
        });
    }
}
