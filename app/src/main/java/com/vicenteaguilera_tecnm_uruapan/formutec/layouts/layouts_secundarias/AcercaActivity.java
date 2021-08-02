package com.vicenteaguilera_tecnm_uruapan.formutec.layouts.layouts_secundarias;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;


import com.vicenteaguilera_tecnm_uruapan.formutec.R;

public class AcercaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca);
        setTitle(R.string.acerca_de);
        WebView webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/about.html");
        webView.setWebViewClient( new WebViewClient());


    }
}
