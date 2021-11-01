package com.example.lesson35;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.lesson35.databinding.ActivityMainBinding;

import Fragments.FirstFragment;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        getSupportFragmentManager().beginTransaction().add(R.id.container, new FirstFragment()).commit();
    }
}