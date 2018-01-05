package tech.brilliantwolf.shopify;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohammed Al on 1/4/2018.
 */

public class JSONFromHTTP {
    String JSON_URL = "https://shopicruit.myshopify.com/admin/products.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6";

    private static URL createUrl(String stringUrl){
        URL url = null;
        try{
            url = new URL(stringUrl);
        } catch(MalformedURLException e){
            System.out.println("Error in creating the URL obj from the string url");
            e.printStackTrace();
        }
        return url;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if(inputStream != null){
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null){
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }
    // takes a URL and returns a JSON String
    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";
        if (url == null){
            return null;
        }
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try{
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(15000);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            if(urlConnection.getResponseCode()== 200){
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            }else{
                System.out.println("error response code "+ urlConnection.getResponseCode());
            }
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("error in the IO stream");
        }finally {
            if(urlConnection != null){
                urlConnection.disconnect();
            }
        }if (inputStream != null){
            inputStream.close();
        }
        return jsonResponse;
    }

    private static ArrayList<Product> extractFeaturesFromJson(){
        ArrayList<Product> products = new ArrayList();



        return products;
    }


}
