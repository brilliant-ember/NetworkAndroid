package tech.brilliantwolf.shopify;

import android.graphics.Bitmap;

/**
 * Created by Mohammed Al on 1/4/2018.
 */

public class Product {
    String mName;
    String mType;
    Bitmap mImg;
    public  Product(String name, String type, Bitmap img ){
        mImg = img;
        mName = name;
        mType = type;

    }

    public Bitmap getImg() {
        return mImg;
    }

    public String getName() {
        return mName;
    }

    public String getType() {
        return mType;
    }

}
