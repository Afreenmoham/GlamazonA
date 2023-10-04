package com.example.newapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ModelsActivity extends AppCompatActivity {

    ListView modellistview;

    TextView brandname;
    String[] models={""};
    Integer[] logos;
    int[] logosint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_models);
        //set ids
        modellistview = findViewById(R.id.model_list);
        brandname = findViewById(R.id.name_models);

        //receive data
        models=getIntent().getStringArrayExtra("models");
        String Brandname=getIntent().getStringExtra("brandname");
        logosint=getIntent().getIntArrayExtra("logos");
        //logos=toConvertInteger(logosint);


        //Adapter
        //brandsadapter adapter new brandadapter(this,models);
        //BrandAdapter adapter=new BrandAdapter(this,models,logos);
        //modellistview.setAdapter(adapter);

        brandname.setText(Brandname);

    }
    public static Integer[] toConvertInteger(int[] ids){
        
        Integer[] newArray=new Integer[ids.length];
        for (int i=0; i<ids.length; i++){
            newArray[i]=Integer.valueOf(ids[i]);
        }
        return newArray;
    }
}
