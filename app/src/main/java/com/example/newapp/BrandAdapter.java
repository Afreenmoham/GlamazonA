package com.example.newapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class BrandAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final String[] brands;
    private String[] logos;

    public BrandAdapter(Context context, String[] brands, String[] logos) {
        super(context,R.layout.custom_brand_item,brands);
        this.context=context;
        this.brands=brands;
        this.logos=logos;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater=(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View brand=inflater.inflate(R.layout.custom_brand_item,null,true);

        ImageView logoimg=brand.findViewById(R.id.brand_img);
        TextView brandname=brand.findViewById(R.id.brandname);

        brandname.setText(brands[position]);

        //new
        //picasso or glide for logoing
        File file=new File(logos[position]).getAbsoluteFile();
        Picasso.get().load(file).into(logoimg);

        return brand;
    }
}