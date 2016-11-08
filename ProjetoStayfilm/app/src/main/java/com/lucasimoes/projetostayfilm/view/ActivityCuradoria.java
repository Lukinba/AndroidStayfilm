package com.lucasimoes.projetostayfilm.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


import com.lucasimoes.projetostayfilm.R;

public class ActivityCuradoria extends Activity {

    ProgressDialog pDialog;
    WebView wbCuradoria;
    String status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curadoria);

        wbCuradoria = (WebView) findViewById(R.id.wvCuradoria);

        Intent it = getIntent();
        Bundle extras = it.getExtras();

        if (extras != null) {
            status = extras.getString("status");

        if (status.equals("monitoria")) {
            wbCuradoria.loadUrl("http://stayfilm-curadoria.esy.es/");
            wbCuradoria.getSettings().setJavaScriptEnabled(true);
            wbCuradoria.setWebViewClient(new WebViewClient());
            wbCuradoria.clearCache(true);
        }
            if (status.equals("curadoria")){
                wbCuradoria.loadUrl("http://www.cubologic.com.br/phone/index.html");
                wbCuradoria.getSettings().setJavaScriptEnabled(true);
                wbCuradoria.setWebViewClient(new WebViewClient());
                wbCuradoria.clearCache(true);
            }
        }else{
                Toast.makeText(this, "Erro na abertura de paginas", Toast.LENGTH_SHORT).show();
            }

    }




}
