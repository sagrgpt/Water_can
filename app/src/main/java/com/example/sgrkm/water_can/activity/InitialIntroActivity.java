package com.example.sgrkm.water_can.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import com.example.sgrkm.water_can.R;
import com.google.android.gms.common.api.GoogleApiClient;


public class InitialIntroActivity extends Activity {

    TextView appName;
    private final int SPLASH_DISPLAY_LENGTH = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initialintro);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "Font/ralewayBold.ttf");
        appName = (TextView) findViewById(R.id.appName);
        appName.setTypeface(typeface);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(InitialIntroActivity.this, BookingActivity.class);
                startActivity(i);
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}