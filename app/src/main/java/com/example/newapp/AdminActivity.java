package com.example.newapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminActivity extends AppCompatActivity {

    Button CatAddBtn,CatUpdateBtn,CatdeleteBtn,SubCatAddBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        CatAddBtn=findViewById(R.id.cat_add);
        CatUpdateBtn=findViewById(R.id.cat_update);
        SubCatAddBtn=findViewById(R.id.scat_add);
        CatdeleteBtn=findViewById(R.id.cat_delete);

        CatAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminActivity.this, CrudActivity.class);
                intent.putExtra("purpose","category");
                startActivity(intent);
            }
        });
        CatUpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminActivity.this,CrudActivity.class);
                intent.putExtra("purpose","category");
                startActivity(intent);
            }
        });
        CatdeleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminActivity.this,CrudActivity.class);
                intent.putExtra("purpose","category");
                startActivity(intent);
            }
        });
        SubCatAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminActivity.this, CrudActivity.class);
                intent.putExtra("purpose","subcategory");
                startActivity(intent);
            }
        });
    }
}