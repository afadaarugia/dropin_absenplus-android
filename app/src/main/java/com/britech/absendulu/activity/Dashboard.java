package com.britech.absendulu.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.britech.absendulu.R;
import com.britech.absendulu.fragment.AbsensiFragment;
import com.britech.absendulu.fragment.AkunFragment;
import com.britech.absendulu.fragment.BerandaFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Dashboard extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        loadFragment(new BerandaFragment());
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new BerandaFragment()).commit();
    }
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }

        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment selectedFragment =  null;

        switch (menuItem.getItemId()){
            case R.id.nav_beranda:
                selectedFragment = new BerandaFragment();
                break;

            case R.id.nav_absensi:
                selectedFragment = new AbsensiFragment();
                break;

            case R.id.nav_akun:
                selectedFragment = new AkunFragment();
                break;

        }
        return loadFragment(selectedFragment);
    }

}
