package maraudersmap.takenet.com.br.maraudersmap.services;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import maraudersmap.takenet.com.br.maraudersmap.util.PeopleLocationManager;

public class ConnectivityService extends Service{
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        PeopleLocationManager.modifyLocation();
        stopSelf();

        return Service.START_FLAG_REDELIVERY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
