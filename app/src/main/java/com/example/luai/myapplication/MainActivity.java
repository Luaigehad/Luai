package com.example.luai.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listwiew;
    ArrayList<String> list;
    Button btn;
    EditText input;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn= (Button)findViewById(R.id.btn);
        listwiew=(ListView)findViewById(R.id.listview);
        list= new ArrayList<String>();
        adapter =new ArrayAdapter<String> (getApplicationContext(), android.R.layout.simple_list_item_1,list);


        input=(EditText)findViewById(R.id.input);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String names= input.getText().toString();
                list.add(names);
                listwiew.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }
        });



    }
}