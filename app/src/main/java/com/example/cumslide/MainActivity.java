package com.example.cumslide;

import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private int screenWidth;
    private int screenHeight;
    private ImageView eustaquio;
    private float eustaquioX;
    private float eustaquioY;

    private Handler handler = new Handler();
    private Timer timer = new Timer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //FrameLayout frameLayout = findViewById(R.id.frame_layout);

        //CumSlideView cumSlideView = new CumSlideView(this, null);
        //cumSlideView.setLayoutParams(new FrameLayout.LayoutParams(
        //        FrameLayout.LayoutParams.MATCH_PARENT,
        //        FrameLayout.LayoutParams.MATCH_PARENT));
        //frameLayout.addView(cumSlideView);

        eustaquio = (ImageView)findViewById(R.id.eustaquio);
        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;



        timer.schedule(new TimerTask(){
            @Override
            public void run() {
                handler.post(new Runnable(){
                    @Override
                    public void run() {
                        changePos();
                    }
                });
            }
        }, 0, 20);
    }

    public void changePos(){
        eustaquioY += 7.5;

        eustaquio.setX(eustaquioX);
        eustaquio.setY(eustaquioY);
    }

}
