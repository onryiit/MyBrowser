package com.example.mybrowser;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    private Button btngo;

    private WebView webView;
    private EditText txtadress;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getIntent() != null && getIntent().getData()!= null){
            txtadress.setText(getIntent().getData().toString());
            webView.loadUrl(getIntent().getData().toString());
        }



        btngo = (Button) findViewById(R.id.go);
        txtadress = (EditText) findViewById(R.id.adress);
        webView = (WebView) findViewById(R.id.webview);

        webView.setWebViewClient(new WebViewClient());
        btngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("http://"+txtadress.getText());
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

}