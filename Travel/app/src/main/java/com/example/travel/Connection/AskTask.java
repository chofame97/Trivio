package com.example.travel.Connection;

import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;



import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class AskTask extends AsyncTask<String,String,InputStream> {
    HttpClient httpClient ;
    HttpPost httpPost ;     // POST
    MultipartEntityBuilder builder ;
    private String postUrl ; // HTTPIP+SVRPATH+Mapping
    private String mapping ;
    private String data;

    ArrayList<AskDTO> paramList;
    ArrayList<AskDTO> fileList;

    public String getData() {
        return data;
    }

    public AskTask(String mapping, String data) {
        this.mapping = mapping;
        this.data = data;
    }

    public AskTask(String mapping) {
        this.mapping = mapping;
        paramList = new ArrayList<>();
        fileList = new ArrayList<>();
    }

    public void addParam(String key, String value){
        paramList.add(new AskDTO(key, value));
    }

    public void addFileParam(String key, String value){
        fileList.add(new AskDTO(key, value));
    }

    @Override
    protected InputStream doInBackground(String... strings) {
        postUrl = CommonVal.HTTP_IP + CommonVal.SVRPATH + mapping ;
        builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

       for (int i = 0; i < paramList.size(); i++){
            builder.addTextBody(paramList.get(i).getKey(), paramList.get(i).getValue(),
                    ContentType.create("Multipart/related" , "UTF-8"));
        }

        httpClient = AndroidHttpClient.newInstance("Android");
        httpPost = new HttpPost(postUrl);
        httpPost.setEntity(builder.build());
        InputStream in = null;
        try {
            in = httpClient.execute(httpPost).getEntity().getContent();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return in;
    }
}
