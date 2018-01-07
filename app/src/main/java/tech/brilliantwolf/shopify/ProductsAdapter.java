package tech.brilliantwolf.shopify;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohammed Al on 1/6/2018.
 */

public class ProductsAdapter extends BaseAdapter implements Filterable {

    public List<Product> productsList = null;
    Context context;
    CustomFilter filter;
    List<Product> filterList;


    public ProductsAdapter(MainActivity context, List<Product> shadowCloneJutsu){

        this.context = context;
        productsList = shadowCloneJutsu;
        filterList = shadowCloneJutsu;
    }

    @Override
    public int getCount() {
        return productsList.size();
    }

    @Override
    public Object getItem(int position) {
        return productsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.product_list_item, parent,false );
        }

        Product newProduct = (Product) getItem(position);

        TextView title = convertView.findViewById(R.id.tilte);
        TextView type = convertView.findViewById(R.id.type);
        ImageView img = convertView.findViewById(R.id.image);

        title.setText(newProduct.getName());
        type.setText(newProduct.getType());
        img.setImageBitmap(newProduct.getImg());

        return convertView;

    }


    @Override
    public Filter getFilter() {
        if(filter == null){
            filter = new CustomFilter(filterList, this);
        }
        return filter;
    }
}
