package com.dhims.screenshotapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.dhims.screenshotutils.ScreenShotUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ScreenShotUtils.request(MainActivity.this, getWindow(), (resultCode, bitmap) -> Log.e("ResultCode", "" + resultCode));

        ScreenShotUtils.request(findViewById(R.id.temp), bitmap -> Log.e("Bitmap", "" + bitmap));

    }
}
