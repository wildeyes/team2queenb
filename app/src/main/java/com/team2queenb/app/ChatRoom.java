
package com.team2queenb.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.team2queenb.*;

import java.util.ArrayList;

public class ChatRoom extends AppCompatActivity {
    ArrayList<Message> msgs = new ArrayList<Message>();
    ListView listView;
    MessageAdapter messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);
        // Create an ArrayList of Dessert objects
        listView = (ListView) findViewById(R.id.list);

        getIntent().getStringExtra("taskName");

        msgs.add(new Message("מה התחום התכנסות בסעיף א", "Ilana" ,"", ""));
        msgs.add(new Message("האם בדקת משפט דריכלה?", "Daniel" ,"", ""));
        msgs.add(new Message("לפי דעתי צריך להשתמש במשפט לייבניץ", "Mor" ,"", ""));
        msgs.add(new Message("מגניב אני אנסה לעשות את זה", "Ilana" ,"", ""));
        msgs.add(new Message("הצליח !! :) ", "Ilana" ,"", ""));

        // Create an {@link DessertAdapter}, whose data source is a list of
        // {@link FriendlyMessage}s. The adapter knows how to create list item views for each item
        // in the list.

        // Get a reference to the ListView, and attach the adapter to the listView.
        messageAdapter = new MessageAdapter(this, msgs);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(messageAdapter);
    }
    public void onClickButton(View v) {
        EditText editText = (EditText) findViewById(R.id.editText3);
        msgs.add(new Message(editText.getText().toString(), "Ilana" ,"", ""));
        runOnUiThread(new Runnable() {
            public void run() {
                messageAdapter.notifyDataSetChanged();
                listView.smoothScrollToPosition(messageAdapter.getCount());
            }
        });
    }
}

