package com.gmind.app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.gmind.app.databinding.ActivityDescriptionBinding;
import com.gmind.app.databinding.ActivityLoginBinding;

import java.util.Objects;

public class DescriptionActivity extends AppCompatActivity {

    ActivityDescriptionBinding binding;
    Boolean resume, favIconChecked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding = ActivityDescriptionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).hide();
        resume = true;
        favIconChecked = true;

        binding.favIcon.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                if (favIconChecked) {
                    favIconChecked = false;
                    binding.favIcon.setImageDrawable(getResources().getDrawable(
                            R.drawable.fav_selected
                    ));
                } else {
                    favIconChecked = true;
                    binding.favIcon.setImageDrawable(getResources().getDrawable(
                            R.drawable.fav_not_selected
                    ));
                }
            }
        });

        binding.playButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                if (resume) {
                    resume = false;
                    binding.playButton.setImageDrawable(getResources().getDrawable(
                            R.drawable.ic_pause
                    ));
                } else {
                    resume = true;
                    binding.playButton.setImageDrawable(getResources().getDrawable(
                            R.drawable.ic_play_arrow
                    ));
                }
            }
        });
    }
}