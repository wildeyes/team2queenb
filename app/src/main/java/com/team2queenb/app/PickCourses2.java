package com.team2queenb.app;

import android.content.Intent;
import android.widget.AdapterView.OnItemClickListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.team2queenb.CustomListAdaptorEntry;

public class PickCourses2 extends AppCompatActivity {

    //courses
    ListView coursesListView;
    String [] couresNames= {"אלגוריתמים", "מבוא למדעי המחשב ושפת ג'אווה","אלגברה לינארית 1"};
    Integer [] couresImages={
            R.drawable.chat_room_icon,
            R.drawable.chat_room_icon,
            R.drawable.chat_room_icon};
    String [] info={
            "5 מטלות" ,"5 מטלות","5 מטלות"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_courses);

        CustomListAdaptorEntry whatever = new CustomListAdaptorEntry(this, couresNames, couresImages,info);
        coursesListView = (ListView) findViewById(R.id.listviewID);
        coursesListView.setAdapter(whatever);

        coursesListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(PickCourses2.this, Tasks.class);
                String message = couresNames[position];
                intent.putExtra("animal", message);
                startActivity(intent);

            }
        });


    }


}








