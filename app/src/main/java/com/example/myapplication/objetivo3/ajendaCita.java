package com.example.myapplication.objetivo3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.myapplication.R;

public class ajendaCita extends AppCompatActivity {

    String url = "https://citamedicadigital.imss.gob.mx/CMW/cmw;jsessionid=zEJubApa0JsGfjXaImxPzYX21jnsAE8lo3S1-1VPehJjLlWIJ82y!-1175422600!383785396?v=login";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajenda_cita);

        WebView web = findViewById(R.id.webViewAjendaCita);
        web.setWebViewClient(new MyWebViewClient());
        WebSettings settings = web.getSettings();
        settings.setJavaScriptEnabled(true);
        web.loadUrl(url);
    }

    private class MyWebViewClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            view.loadUrl(url);
            return true;
        }
    }
}
