package com.qdnerak.practica3.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.qdnerak.practica3.R;
import com.qdnerak.practica3.view.fragment.HomeFragment;
import com.qdnerak.practica3.view.fragment.ProfileFragment;
import com.qdnerak.practica3.view.fragment.SearchFragment;

public class ContainerActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container2);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;

                        switch (item.getItemId()){
                            case R.id.search:
                                selectedFragment = new SearchFragment();
                                break;
                            case R.id.home:
                                selectedFragment = new HomeFragment();
                                break;
                            case R.id.profile:
                                selectedFragment = new ProfileFragment();
                                break;
                        }

                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.contaimer_frame, selectedFragment)
                                .commit();

                        return true;
                    }
                }
        );
    }
}