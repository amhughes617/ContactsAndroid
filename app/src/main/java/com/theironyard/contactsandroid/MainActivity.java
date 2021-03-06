package com.theironyard.contactsandroid;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener {


    ArrayAdapter<Contact> items;

    ListView list;
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

        items = new ArrayAdapter<Contact>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(items);

        addButton.setOnClickListener(this);
        list.setOnItemLongClickListener(this);
        list.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = nameText.getText().toString();
        String phone = phoneText.getText().toString();
        if (phone.length() == 10) {
            phone = String.format("%s-%s-%s", phone.substring(0, 3), phone.substring(3, 6), phone.substring(6));
        }
        else if (phone.length() == 7) {
            phone = String.format("%s-%s", phone.substring(0, 3), phone.substring(3));
        }
        else {
            phoneText.setText("");
        }
        if ( !nameText.getText().toString().isEmpty() && !phoneText.getText().toString().isEmpty()) {
            items.add(new Contact(name, phone));
        }
        nameText.setText("");
        phoneText.setText("");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Contact item = items.getItem(position);
        items.remove(item);
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Contact contact = items.getItem(position);
        Intent intent = new Intent(MainActivity.this, Main2Activity.class); //saw this on treehouse.com
        intent.putExtra("Contact", (Parcelable) contact);
        startActivity(intent);
    }
}
