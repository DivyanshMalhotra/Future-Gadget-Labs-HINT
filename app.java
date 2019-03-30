package com.example.nodemc;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String ssid= "Esp8266TestNet";
        String key="Esp8266Test";
        WifiConfiguration conf = new WifiConfiguration();
        conf.SSID = "\"" + ssid + "\""; ;
        conf.preSharedKey = "\""+ key +"\"";

        WifiManager wifiManager = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifiManager.addNetwork(conf);
        myWebView = (WebView) findViewById(R.id.webview);


    }
    public void send(View view){

        myWebView.loadUrl("http://192.168.4.1/led/off");
        //myWebView.setVisibility(View.GONE);
    }

}
