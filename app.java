package com.example.nodemc;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WebView myWebView;
    public LocationManager lm;                 //sets a location manager named lm
    public LocationListener locationListener;
    public String SOSloc;
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
    public void SOS(View view){
        lm = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);
        locationListener = new MyLocationListener();
        Location loc = null;
        try {
            lm.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    0,
                    0,
                    locationListener);
            loc = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        } catch (SecurityException e) {
            Toast.makeText(getBaseContext(),
                    "Can't access GPS values",
                    Toast.LENGTH_SHORT).show();
        }
        if (loc != null) {
            SOSloc= "loc.getLatitude()" + "/loc.getLongitude()" + "/loc.getAltitude()" ;
            Toast.makeText(getBaseContext(),
                    "Location Sent to Rescue Team",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getBaseContext(),
                    "Location is null",
                    Toast.LENGTH_SHORT).show();
        }
        myWebView.loadUrl("http://192.168.4.1/led/"+SOSloc);
    }
    private class MyLocationListener implements LocationListener
    {
        @Override
        public void onLocationChanged(Location loc) {
            // TODO Auto-generated method stub
        }
        @Override
        public void onProviderDisabled(String provider) {
            // TODO Auto-generated method stub
        }
        @Override
        public void onProviderEnabled(String provider) {
            // TODO Auto-generated method stub
        }
        @Override
        public void onStatusChanged(String provider, int status,
                                    Bundle extras) {
            // TODO Auto-generated method stub
        }
    }
}
