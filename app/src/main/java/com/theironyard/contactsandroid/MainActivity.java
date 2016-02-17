package com.theironyard.contactsandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;






public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {

    ArrayAdapter<String> items;

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

        items = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(items);

        addButton.setOnClickListener(this);
        list.setOnItemLongClickListener(this);
    }


    @Override
    public void onClick(View v) {
        String name = nameText.getText().toString();
        String phone = phoneText.getText().toString();
        items.add(String.format("%s(%s)", name, phone));
        nameText.setText("");
        phoneText.setText("");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String item = items.getItem(position);
        items.remove(item);
        return true;
    }
}
