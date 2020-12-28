package com.example.practikum;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    UserListAdapter adapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list);

        ArrayList<User> users = new ArrayList<>();

        // TODO: реализовать загрузку данных из JSON-файла
        // который загрузить в папку assets

        Gson gson = new Gson();
        try {
            InputStream stream = getAssets().open("users.json");
            User[] userss = gson.fromJson(new InputStreamReader(stream), User[].class);

            users = new ArrayList<>(Arrays.asList(userss));

            adapter = new UserListAdapter(this, users);
            adapter.notifyDataSetChanged();
            listView.setAdapter(adapter);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}