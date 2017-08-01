package com.ramotion.foldingcell.examples.listview;

import android.content.Context;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by nusrat on 7/30/2017.
 */

public class Configuration {
    Apps read(Context context) {
        BufferedReader reader = null;
        Apps apps;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(context.getAssets().open("app_info.json")));

            // do reading, usually loop until end of file reading
            Gson gson = new Gson();
            apps = gson.fromJson(reader, Apps.class);
            return apps;
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }
        return null;
    }
}
