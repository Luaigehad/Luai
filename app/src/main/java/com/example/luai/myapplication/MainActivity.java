package com.example.luai.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listwiew;
    ArrayList<String> list;
    Button btn;
    EditText input;
    ArrayAdapter adapter;
    EditText erase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn= (Button)findViewById(R.id.btn);
        listwiew=(ListView)findViewById(R.id.listview);
        list= new ArrayList<String>();
        adapter =new ArrayAdapter<String> (getApplicationContext(), android.R.layout.simple_list_item_1,list);
        input=(EditText)findViewById(R.id.input);
       erase=(EditText)findViewById(R.id.input);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String names= input.getText().toString();
                list.add(names);
                listwiew.setAdapter(adapter);

                listwiew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(MainActivity.this, "name  "+list.get(position) , Toast.LENGTH_SHORT).show();


                        adapter.notifyDataSetChanged();


                    }
                });

                listwiew.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                        Toast.makeText(MainActivity.this, list.remove(position), Toast.LENGTH_LONG).show();
                        // list.remove(position);
                        adapter.notifyDataSetChanged();
                        return false;

                    }
                });

                erase.setText("");

            }
        });



    }
}