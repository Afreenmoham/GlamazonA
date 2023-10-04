package com.example.newapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

    String[] brand_names={"L'OREAL" , "MAYBELLINE" , "FACES CANADA" , "M.A.C" , "RARE BEAUTY" , "BIOTIQUE" , "NEUTROGENA" , "mCAFFIENE" , "KYLIE COSMETICS" , "PILIGRIM"  , "PATANJALI"};

    ListView brandlistView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        //setids
        brandlistView=findViewById(R.id.listView);
        //adapter
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,brand_names);
        brandlistView.setAdapter(adapter);
    }
}