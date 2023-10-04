package com.example.newapp;

import androidx.annotation.NonNull;
import android.content.Intent;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.database.Cursor;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.Locale;

public class BrandsActivity extends AppCompatActivity {

    String[] brands_names={};
    String[] logos={};
    ListView listview;
    ShopDataSqlite shopDataSqlite;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brands);
        shopDataSqlite=new ShopDataSqlite(this);
        //set ids
        listview=findViewById(R.id.listView);
        String purpose="category";

        readCategory(purpose);

        BrandAdapter adapter=new BrandAdapter(this,brands_names,logos);
        listview.setAdapter(adapter);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int position = i;
                String brandsselected = listview.getItemAtPosition(position).toString();
                Toast.makeText(BrandsActivity.this, "Selected: " + brandsselected, Toast.LENGTH_SHORT).show();
            }


//                String[] models={""};
//                int[] logos={};
//                if (brandsselected.equals("L'OREAL")){
//                    logosarray=toint(logos1);
//                } else if (brandsselected.equals("MAYBELLINE")) {
//                    models = brand2;
//                    logosarray = toint(logos2);
//                }else if(brandsselected.equals("FACES CANADA")){
//                    models=brand3;
//                    logosarray=toint(logos3);
//                } else if (brandsselected.equals("M.A.C")) {
//                    models=brand4;
//                    logosarray=toint(logos4);
//                } else if (brandsselected.equals("RARE BEAUTY")) {
//                    models=brand5;
//                    logosarray=toint(logos5);
//                } else if (brandsselected.equals("BIOTIQUE")) {
//                    models=brand6;
//                    logosarray=toint(logos6);
//                } else if (brandsselected.equals("NEUTROGENA")) {
//                    models=brand7;
//                    logosarray=toint(logos7);
//                } else if (brandsselected.equals("mCAFFIENE")) {
//                    models=brand8;
//                    logosarray=toint(logos8);
//                } else if (brandsselected.equals("KYLIE COSMETICS")) {
//                    models=brand9;
//                    logosarray=toint(logos9);
//                }
//
//
//                Intent intent=new Intent(BrandsActivity.this, ModelsActivity.class);
//                intent.putExtra("models",models);
//                intent.putExtra("brandname",brandsselected);
//                intent.putExtra("logos",logosarray);
//                startActivity(intent);
        });
    }
    private void readCategory(String purpose){
        String condition=null;
        Cursor result=shopDataSqlite.listData(purpose,condition);
        if (result.getCount()==0){
            displayMessage("data","No Data Found");
        }
        ArrayList<String> arrayList=new ArrayList<String>();
        ArrayList<String> logoArray=new ArrayList<>();
        while (result.moveToNext()){
            arrayList.add(result.getString(1));
            logoArray.add(result.getString(2));
            Log.i("image db: ",result.getString(2));
        }
        //name string array
        brands_names=new String[arrayList.size()];
        for(int i=0;i<arrayList.size();i++){
            brands_names[i]=arrayList.get(i);
        }
        //logo string array
        logos=new String[logoArray.size()];
        for (int i=0;i<logoArray.size();i++){
            logos[i]=logoArray.get(i);
            Log.i("image address:"+i,logoArray.get(i));
        }
    }
    private void displayMessage(String data, String message) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.create();
        builder.setCancelable(true);
        builder.setTitle(data);
        builder.setMessage(message);
        builder.show();
    }
    public static int[] toint(Integer[] WrapperArray){
        int[] newArray = new int[WrapperArray.length];
        for (int i=0;i<WrapperArray.length;i++){
            newArray[i]= WrapperArray[i].intValue();
        }
        return newArray;
    }
}