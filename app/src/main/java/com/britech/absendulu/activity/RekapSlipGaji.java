package com.britech.absendulu.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.webkit.WebView;

import com.britech.absendulu.R;

public class RekapSlipGaji extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rekap_slip_gaji);
        Toolbar ToolBar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(ToolBar);
        ToolBar.setLogoDescription(getResources().getString(R.string.app_name));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webView = findViewById(R.id.webView);
        webView.loadUrl("http://6714de4d126f.ngrok.io/web_portal/web/public/show_slip_gaji");
    }
}
