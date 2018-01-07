package tech.brilliantwolf.shopify;

import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohammed Al on 1/7/2018.
 */

public class CustomFilter extends Filter{

    List<Product> filterList;
    ProductsAdapter adapter;

    public CustomFilter(List<Product> list, ProductsAdapter adapter){
        this.filterList = list;
        this.adapter = adapter;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        if (constraint != null && constraint.length()>0){
            constraint = constraint.toString().toLowerCase();
            ArrayList<Product>filteredProducts = new ArrayList<>();

            for(int i=0; i<filterList.size(); i++){
                if (filterList.get(i).getName().toLowerCase().contains(constraint)){
                    filteredProducts.add(filterList.get(i));
                }
            }
            results.count = filteredProducts.size();
            results.values = filteredProducts;
        }
        else{
            results.count = filterList.size();
            results.values = filterList;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        adapter.productsList =( ArrayList<Product> ) results.values;
        adapter.notifyDataSetChanged();;
    }
}
