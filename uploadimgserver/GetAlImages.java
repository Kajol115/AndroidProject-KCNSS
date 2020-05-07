package com.example.dell.uploadimgserver;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dell on 14/03/2018.
 */

/*      We will pass the json string having all the urls of our images to the constructor of this class.
        We will get the json string having all the urls from our getAllImages.php script.         */

public class GetAlImages {

    public static String[] imageURLs;
    public static Bitmap[] bitmaps;
    public static String[] names;
    public static final String JSON_ARRAY="result";
    public static final String IMAGE_URL = "image_path";
    public static final String IMAGE_NAME = "image_name";
    private String json;
    private JSONArray urls;

    public GetAlImages(String json){
        this.json = json;
        try {
            JSONObject jsonObject = new JSONObject(json);
            urls = jsonObject.getJSONArray(JSON_ARRAY);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private Bitmap getImage(JSONObject jo){
        URL url = null;
        Bitmap image = null;
        try {
            url = new URL(jo.getString(IMAGE_URL));
            image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return image;
    }

    public void getAllImages() throws JSONException {

        names=new String[urls.length()];
        bitmaps = new Bitmap[urls.length()];

        imageURLs = new String[urls.length()];

        for(int i=0;i<urls.length();i++){
            names[i]=urls.getJSONObject(i).getString(IMAGE_NAME);
            imageURLs[i] = urls.getJSONObject(i).getString(IMAGE_URL);
            JSONObject jsonObject = urls.getJSONObject(i);
            bitmaps[i]=getImage(jsonObject);
        }
    }
}