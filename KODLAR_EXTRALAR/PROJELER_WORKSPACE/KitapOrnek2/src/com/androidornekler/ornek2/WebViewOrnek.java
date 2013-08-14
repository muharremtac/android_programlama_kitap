package com.androidornekler.ornek2;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewOrnek extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webviewornek);
        WebView webView = (WebView) findViewById(R.id.webview);
        webView.loadUrl("http://www.gelecekonline.com/mobile");
    }
}