package com.example.cumslide;

import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private int screenWidth;
    private int screenHeight;
    private ImageView mario;
    private float marioX;
    private float marioY;

    private boolean inBridge;

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

        mario = (ImageView)findViewById(R.id.mario);
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
        if(marioX == 0) {
            marioX = 45;
            mario.setX(marioX);
            inBridge = false;
        }

        if(inBridge){
            if(Bridge.source.getY()==Bridge.target.getY()){ //Horizontal
                marioX += 5;
                mario.setX(marioX);
            } else{ //Diagonal

            }
        }
        else {
            marioY += 5;
            mario.setY(marioY);
            //if(CumSlide.matrix.get(Math.round(marioX)+1).get(Math.round(marioY))!=0) {
            //    inBridge = true;
            //}

        }

    }

}
