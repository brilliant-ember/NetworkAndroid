package tech.brilliantwolf.shopify;

/**
 * Created by Mohammed Al on 1/4/2018.
 */

public class Product {
    String mName;
    String mType;
    String mImgUrl;
    public  Product(String name, String type, String imgUrl ){
        mImgUrl = imgUrl;
        mName = name;
        mType = type;

    }

    public String getImgUrl() {
        return mImgUrl;
    }

    public String getName() {
        return mName;
    }

    public String getType() {
        return mType;
    }
}
