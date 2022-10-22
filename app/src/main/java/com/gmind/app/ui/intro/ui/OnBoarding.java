package com.gmind.app.ui.intro.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.gmind.app.R;

import com.gmind.app.ui.intro.adapter.Adapter_walkthrough;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class OnBoarding extends AppCompatActivity {
    public ViewPager viewPager;
    Adapter_walkthrough adapter_walkthrough;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);
        viewPager = findViewById(R.id.viewPager);
        CircleIndicator circleIndicator = findViewById(R.id.indicator);
        adapter_walkthrough = new Adapter_walkthrough(getSupportFragmentManager());
        viewPager.setAdapter(adapter_walkthrough);
        circleIndicator.setViewPager(viewPager);
        adapter_walkthrough.registerDataSetObserver(circleIndicator.getDataSetObserver());
        //Timer
        Timer timer =new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(),2000,4000);

    }
    public class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            OnBoarding.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem()==0){
                        viewPager.setCurrentItem(1);

                    }else if (viewPager.getCurrentItem()==1){
                        viewPager.setCurrentItem(2);
                    }else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}