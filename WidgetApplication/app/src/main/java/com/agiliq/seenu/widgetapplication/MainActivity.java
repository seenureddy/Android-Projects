package com.agiliq.seenu.widgetapplication;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

/**
 * Created by seenu on 3/3/15.
 */
public class MainActivity extends Activity {
    private View mColorRegion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mColorRegion = findViewById(R.id.color_region);
        Button b1 = (Button)findViewById(R.id.button1);
        Button b2 = (Button)findViewById(R.id.button2);
        Button b3 = (Button)findViewById(R.id.button3);

        RadioButton rb1 = (RadioButton)findViewById(R.id.radio_button1);
        RadioButton rb2 = (RadioButton)findViewById(R.id.radio_button2);
        RadioButton rb3 = (RadioButton)findViewById(R.id.radio_button3);

        b1.setOnClickListener(new ColorSetter(Color.BLUE, this));
        b2.setOnClickListener(new ColorSetter(Color.GREEN, this));
        b3.setOnClickListener(new ColorSetter(Color.RED, this));
        rb1.setOnClickListener(new ColorSetter(Color.BLUE, this));
        rb2.setOnClickListener(new ColorSetter(Color.GREEN, this));
        rb3.setOnClickListener(new ColorSetter(Color.RED, this));
    }

    public void setMycolorRegion(int color) {
        mColorRegion.setBackgroundColor(color);

    }
}
