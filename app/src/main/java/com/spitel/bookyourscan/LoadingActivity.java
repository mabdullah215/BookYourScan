package com.spitel.bookyourscan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public class LoadingActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_loading);
        TimerTask task = new TimerTask()
        {
            @Override
            public void run()
            {
                startActivity(new Intent(getBaseContext(),SplashActivity.class));
                finish();
            }
        };

        new Timer().schedule(task, 3000);


    }
}
