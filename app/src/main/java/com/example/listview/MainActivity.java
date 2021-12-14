package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] devices = new String[] {
            "Телефоны",
            "Планшеты",
            "Ноутбуки",
            "Компьютеры"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_multiple_choice, devices
        );

        listView.setAdapter(listViewAdapter);

        listView.setOnItemClickListener((adapterView, view, index, l) -> {
            List<String> selectedItemsList = new ArrayList<>();

            SparseBooleanArray checked = listView.getCheckedItemPositions();
            for (int i = 0; i < checked.size(); i++) {
                if (checked.valueAt(i)) {
                    selectedItemsList.add(listView.getItemAtPosition(checked.keyAt(i)).toString());
                }
            }

            Toast.makeText(
                    getApplicationContext(),
                    TextUtils.join(", ", selectedItemsList),
                    Toast.LENGTH_SHORT
            ).show();
        });
    }
}