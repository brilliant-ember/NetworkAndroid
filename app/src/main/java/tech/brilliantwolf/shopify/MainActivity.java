package tech.brilliantwolf.shopify;



import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    ListView root;
    ProductsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText2);
        root = findViewById(R.id.root);

//        String url = "https://cdn.shopify.com/s/files/1/1000/7970/products/Aerodynamic_20Concrete_20Clock.png?v=1443055734";
//        new GetImageFromURL(img).execute(url);

        String fullJsonUrl = "https://shopicruit.myshopify.com/admin/products.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6";

        new RequestProducts().execute(fullJsonUrl);
    }




    private class RequestProducts extends AsyncTask<String, Void, List<Product>>{

        @Override
        protected List<Product> doInBackground(String... urls) {
            List<Product> result = JSONFromHTTP.productsFromUrl(urls[0]);
            return result;
        }

        protected void onPostExecute(final List<Product> data) {
            root.setTextFilterEnabled(true);
            adapter = new ProductsAdapter(MainActivity.this ,data);
           root.setAdapter( adapter);
           editText.addTextChangedListener(new TextWatcher() {
               @Override
               public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                   adapter.getFilter().filter(s);

               }

               @Override
               public void onTextChanged(CharSequence s, int start, int before, int count) {

               }

               @Override
               public void afterTextChanged(Editable s) {

               }
           });


           root.setOnItemClickListener(new AdapterView.OnItemClickListener() {
               @Override
               public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                   Product p = data.get(position);
                   MyDialoge myDialoge = new MyDialoge();
                   myDialoge.takeProductFeatures(p.getName(),p.getType(),p.getImg());
                   myDialoge.show(getFragmentManager(),"Screen");


               }
           });

        }
    }

//    public class GetImageFromURL extends AsyncTask<String, Void, Bitmap>{
//        ImageView imgView;
//        public GetImageFromURL(ImageView imgV){
//            this.imgView = imgV;
//        }
//
//        @Override
//        protected Bitmap doInBackground(String... url) {
//            String urlString = url[0];
//            bitmap = null;
//            try{
//                InputStream in = new URL(urlString).openStream();
//                bitmap = BitmapFactory.decodeStream(in);
//            } catch (Exception e){
//                e.printStackTrace();
//            }
//            return bitmap;
//
//        }
//        protected void onPostExecute(Bitmap bitmap){
//            super.onPostExecute(bitmap);
//            imgView.setImageBitmap(bitmap);
//
//        }
//
//    }
}
