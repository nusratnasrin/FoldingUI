package com.ramotion.foldingcell.examples.listview;

import android.view.View;

import java.util.ArrayList;

/**
 * Created by nusrat on 7/30/2017.
 */

public class App {
    String id;
    String title;
    String description;
    String icon;
    String detail_description;
    String version;
    String update;
    private View.OnClickListener requestBtnClickListener;

    public View.OnClickListener getRequestBtnClickListener() {
        return requestBtnClickListener;
    }

    public void setRequestBtnClickListener(View.OnClickListener requestBtnClickListener) {
        this.requestBtnClickListener = requestBtnClickListener;
    }

    /**
     * @return List of elements prepared for tests
     */

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }

    public String getDetail_description(){
        return detail_description;}
    public String getVersion(){
        return version;
    }
public String getUpdate(){
    return update;
}
}