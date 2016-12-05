package com.example.satya.adpterclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    Button bt1;
    EditText et1;
    ArrayList <String>al = new ArrayList<String>();
    ArrayAdapter<String> a;
    ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = (Button) findViewById(R.id.bt1);
        et1 = (EditText) findViewById(R.id.et1);
        lv1 = (ListView) findViewById(R.id.lv1);

        // below line  establishing connection ArrayAdpter with ArrayList
        a = new ArrayAdapter<String>(this, R.layout.row,al);
        //establish connection ArrayAdaptr to listView
        lv1.setAdapter(a);
        //Implement List view Item Click Listener
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                       @Override
                                       public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                           //3rd parameter is important position of the element
                                           //al.get(i) is getting the data of thet postion
                                           //at the place of al.get(i) if we give only i then it will show only the postion
                                           Toast.makeText(MainActivity.this, "Position.."+al.get(i), Toast.LENGTH_SHORT).show();
                                       }
                                   }
        );
        //implement button click listener

        bt1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                //read city from EditText
                String city = et1.getText().toString().trim();
                if (city.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Enter City", Toast.LENGTH_SHORT).show();
                    return;
                }
                //add city name to source
                al.add(city);
                //for taking input in a sorting order
                Collections.sort(al);
                //tell to Adaptor
                a.notifyDataSetChanged();
                //now claen EditText
                et1.setText("");
                //move cursor again to the starting postion
                et1.requestFocus();
            }
        });
    }
}
