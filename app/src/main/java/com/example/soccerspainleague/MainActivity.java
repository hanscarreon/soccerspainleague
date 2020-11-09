package com.example.soccerspainleague;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.soccerspainleague.fragments.GamesFragment;
import com.example.soccerspainleague.fragments.HomeFragment;
import com.example.soccerspainleague.fragments.LeaguesFragment;
import com.example.soccerspainleague.fragments.LiveFragment;
import com.example.soccerspainleague.fragments.TeamsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.main_navigation_menu);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.teams:
                        fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.frame_layout, new TeamsFragment()).commit();
                        return true;


                    case R.id.games:
                        fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.frame_layout, new GamesFragment()).commit();
                        return true;

                    case R.id.leagues:
                        fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.frame_layout, new LeaguesFragment()).commit();
                        return true;

                    case R.id.live:
                        fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.frame_layout, new LiveFragment()).commit();
                        return true;

                    case R.id.home:
                        fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();
                        return true;
                }

                return false;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.home);
    }
}