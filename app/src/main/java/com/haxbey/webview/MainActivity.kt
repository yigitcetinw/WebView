package com.haxbey.webview

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView = findViewById<WebView>(R.id.webView)
        
        // Site ayarları
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        
        // Linke tıklayınca tarayıcıya atmaması, uygulama içinde kalması için
        webView.webViewClient = WebViewClient() 
        
        // Açılacak site
        webView.loadUrl("https://www.youtube.com")

        // Geri tuşu kontrolü (Uygulamadan çıkmak yerine bir önceki sayfaya döner)
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (webView.canGoBack()) {
                    webView.goBack()
                } else {
                    finish()
                }
            }
        })
    }
}
