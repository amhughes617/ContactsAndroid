package com.theironyard.contactsandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener {
    static String contact;
    ArrayAdapter<String> items;

    static ListView list;
    EditText nameText;
    EditText phoneText;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.listView);
        nameText = (EditText) findViewById(R.id.editName);
        phoneText = (EditText) findViewById(R.id.editPhone);
        addButton = (Button) findViewById(R.id.addButton);

        items = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(items);

        addButton.setOnClickListener(this);
        list.setOnItemLongClickListener(this);
        list.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = nameText.getText().toString();
        String phone = phoneText.getText().toString();
        if ( !nameText.getText().toString().isEmpty() && !nameText.getText().toString().isEmpty()) {
            items.add(String.format("%s(%s)", name, phone));
        }
        nameText.setText("");
        phoneText.setText("");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String item = items.getItem(position);
        items.remove(item);
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        contact = items.getItem(position);
        Intent intent = new Intent(MainActivity.this, Main2Activity.class); //saw this on treehouse.com
        startActivity(intent);
    }
}
