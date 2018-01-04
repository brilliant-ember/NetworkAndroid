package tech.brilliantwolf.shopify;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView name = findViewById(R.id.textView);
        TextView description = findViewById(R.id.textView2);
        img = findViewById(R.id.imageView2);

        String url = "https://cdn.shopify.com/s/files/1/1000/7970/products/Aerodynamic_20Concrete_20Clock.png?v=1443055734";
        new GetImageFromURL(img).execute(url);
    }
    public class GetImageFromURL extends AsyncTask<String, Void, Bitmap>{
        ImageView imgView;
        public GetImageFromURL(ImageView imgV){
            this.imgView = imgV;
        }

        @Override
        protected Bitmap doInBackground(String... url) {
            String urlString = url[0];
            bitmap = null;
            try{
                InputStream in = new URL(urlString).openStream();
                bitmap = BitmapFactory.decodeStream(in);
            } catch (Exception e){
                e.printStackTrace();
            }
            return bitmap;

        }
        protected void onPostExecute(Bitmap bitmap){
            super.onPostExecute(bitmap);
            imgView.setImageBitmap(bitmap);

        }

    }
}
