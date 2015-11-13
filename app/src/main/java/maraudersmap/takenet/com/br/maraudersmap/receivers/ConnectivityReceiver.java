package maraudersmap.takenet.com.br.maraudersmap.receivers;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import maraudersmap.takenet.com.br.maraudersmap.services.ConnectivityService;

public class ConnectivityReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent i = new Intent();
        i.setClass(context, ConnectivityService.class);
        context.startService(i);

    }



}
