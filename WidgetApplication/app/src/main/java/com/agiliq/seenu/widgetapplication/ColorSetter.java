package com.agiliq.seenu.widgetapplication;

import android.view.View;

/**
 * Created by seenu on 3/3/15.
 */
public class ColorSetter implements View.OnClickListener {
    private int regionColor;
    private MainActivity mainActivity;

    public ColorSetter(int regionColor, MainActivity mainActivity) {
        this.regionColor = regionColor;
        this.mainActivity = mainActivity;
    }
    @Override
    public void onClick(View v){
        mainActivity.setMycolorRegion(regionColor);
    }
}
