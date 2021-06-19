package com.britech.absendulu.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.britech.absendulu.R;

public class RekapKehadiran extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rekap_kehadiran);
        Toolbar ToolBar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(ToolBar);
        ToolBar.setLogoDescription(getResources().getString(R.string.app_name));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
