package maraudersmap.takenet.com.br.maraudersmap.util;

import android.content.Context;
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

}
