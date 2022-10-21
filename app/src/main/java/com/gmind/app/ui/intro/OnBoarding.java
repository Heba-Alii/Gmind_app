package com.gmind.app.ui.intro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.gmind.app.R;

import com.gmind.app.ui.intro.adapter.Adapter_walkthrough;

import me.relex.circleindicator.CircleIndicator;

public class OnBoarding extends AppCompatActivity {
    public ViewPager viewPager;
    Adapter_walkthrough adapter_walkthrough;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);
        viewPager=findViewById(R.id.viewPager);
        CircleIndicator circleIndicator=findViewById(R.id.indicator);
        adapter_walkthrough=new Adapter_walkthrough(getSupportFragmentManager());
        viewPager.setAdapter(adapter_walkthrough);
     circleIndicator.setViewPager(viewPager);
       adapter_walkthrough.registerDataSetObserver(circleIndicator.getDataSetObserver());


    }
}