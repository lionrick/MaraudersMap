package maraudersmap.takenet.com.br.maraudersmap.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

import maraudersmap.takenet.com.br.maraudersmap.MaraudersMapApplication;

public class NetWorkUtil {

    public static String getMacAddress() {
        WifiManager manager = (WifiManager) MaraudersMapApplication.getContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = manager.getConnectionInfo();
        String address = info.getMacAddress();
        return address;
    }

    public static String getRouterMacAddress() {
        WifiManager manager = (WifiManager) MaraudersMapApplication.getContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = manager.getConnectionInfo();
        String address = info.getBSSID();
        return address;
    }

    public static boolean isWifiConnected(){
        final ConnectivityManager connMgr = (ConnectivityManager) MaraudersMapApplication.getContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        final android.net.NetworkInfo wifi = connMgr
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        return wifi.isConnected();
    }

}
