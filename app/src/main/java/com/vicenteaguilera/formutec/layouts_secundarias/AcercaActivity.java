package com.vicenteaguilera.formutec.layouts_secundarias;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;


import com.vicenteaguilera.formutec.R;

public class AcercaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca);
        setTitle(R.string.acerca_de);
        WebView webView = findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/about.html");//app/src/main/assets/about.html"file:///android_assets/about.html""http://www.google.com"
        webView.setWebViewClient( new WebViewClient());


    }
}
