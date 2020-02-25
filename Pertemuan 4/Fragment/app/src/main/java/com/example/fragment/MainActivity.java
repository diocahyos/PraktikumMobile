package com.example.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private Fragment selectedFragmanet = new MoviesFragment();
    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.activitymain_btmNav);

        bottomNav.setOnNavigationItemSelectedListener(this);

        loadFragment(selectedFragmanet);
    }

    //Menghendale jika tombol pada item diklik
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.menu_movie:
                selectedFragmanet = new MoviesFragment();
                break;

            case R.id.menu_tvshow:
                selectedFragmanet = new TVShowsFragment();
                break;
        }
        return loadFragment(selectedFragmanet);
    }

    private boolean loadFragment(Fragment selectedFragmanet) {
        if (selectedFragmanet != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activitymain_container,selectedFragmanet)
                    .commit();
            return true;
        }else
            return false;
    }
}
