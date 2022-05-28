package com.example.travel.Connection;

import android.os.AsyncTask;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;

public class CommonMethod {

    static InputStream in = null;
    public static InputStreamReader executeAskGet(AsyncTask<String, String, InputStream> asktask){
        try {
            return new InputStreamReader( asktask.execute().get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
