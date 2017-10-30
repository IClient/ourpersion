package com.example.administrator.OurPersion.View.Activity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.OurPersion.R;


public class WelcomeActivity extends BaseActivity {

    int time = 3;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                welcomeText.setText(time-- + "s");

            }

        }
    };
    TextView welcomeText;
    Button welcomeWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        welcomeText = (TextView) findViewById(R.id.welcome_text);
        welcomeWebview = (Button) findViewById(R.id.welcome_webview);

        welcomeWebview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(welcomeText.getText().toString().trim()));
                startActivity(intent);
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 3; i++) {
                    handler.sendEmptyMessage(1);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
        }).start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this, FirstMainPlanActivity.class);
                WelcomeActivity.this.finish();
                startActivity(intent);
            }
        }, 3000);
    }

}
