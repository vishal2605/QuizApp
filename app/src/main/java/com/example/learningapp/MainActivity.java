package com.example.learningapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.learningapp.ui.code.CodeFragment;
import com.example.learningapp.ui.home.HomeFragment;
import com.example.learningapp.ui.quiz.QuizFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        navigationView=findViewById(R.id.navigation_view);
    }
    private final BottomNavigationView.OnNavigationItemSelectedListener navListener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment=null;
                    switch (item.getItemId()){
                        case R.id.home:
                            selectedFragment=new HomeFragment();
                            break;
                        case R.id.code:
                            selectedFragment=new CodeFragment();
                            break;
                        case R.id.quiz:
                            selectedFragment=new QuizFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.flFragment,
                            selectedFragment).commit();
                    return true;
                }
            };
}