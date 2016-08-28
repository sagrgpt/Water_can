package com.example.sgrkm.water_can.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

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
                SharedPreferences sharedPref = getSharedPreferences("userState", Context.MODE_PRIVATE);
                String state = sharedPref.getString("isLoggedIn", "false");
                Toast.makeText(InitialIntroActivity.this,state,Toast.LENGTH_LONG).show();
                if(state.equals("true")) {
                    Intent i = new Intent(InitialIntroActivity.this, BookingActivity.class);
                    startActivity(i);
                }
                else{
                    Intent i = new Intent(InitialIntroActivity.this, RegisterActivity.class);
                    startActivity(i);
                }
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}