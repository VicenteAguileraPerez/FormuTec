package com.vicenteaguilera.formutec.layouts_secundarias;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.vicenteaguilera.formutec.R;

public class AcercaActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca);
        setTitle(R.string.acerca_de);
        webView = findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/about.html");//app/src/main/assets/about.html"file:///android_assets/about.html""http://www.google.com"
        webView.setWebViewClient( new WebViewClient()
        {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url); // load the url
                return true;
            }
        });


    }
}
