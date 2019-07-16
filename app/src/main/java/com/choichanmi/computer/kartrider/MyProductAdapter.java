package com.choichanmi.computer.kartrider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyProductAdapter extends BaseAdapter {
    Context context;
    MyProductList[] myProductLists;
    public MyProductAdapter(Context context, MyProductList[] myProductLists){
        this.context = context;
        this.myProductLists = myProductLists;
    }
    @Override
    public int getCount() {
        return myProductLists.length;
    }

    @Override
    public Object getItem(int position) {
        return myProductLists[position];
    }

    @Override
    public long getItemId(int position) {
        return (long)position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.listview_product_item,null);
        MyProductList myProductList = myProductLists[position];

        TextView textViewName = convertView.findViewById(R.id.my_product_name);
        TextView textViewPrice = convertView.findViewById(R.id.my_product_price);
        TextView textViewCapacity = convertView.findViewById(R.id.my_product_capacity);
        TextView textViewCountry = convertView.findViewById(R.id.my_product_country);

        textViewName.setText(myProductList.getName());
        textViewCapacity.setText(myProductList.getCapacity());
        textViewPrice.setText(myProductList.getPrice());
        textViewCountry.setText(myProductList.getCountry());
        return convertView;
    }
}
