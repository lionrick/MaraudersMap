package maraudersmap.takenet.com.br.maraudersmap;

import android.app.Application;
import android.content.Context;

import com.firebase.client.Firebase;

import maraudersmap.takenet.com.br.maraudersmap.model.Local;
import maraudersmap.takenet.com.br.maraudersmap.model.LocalDao;
import maraudersmap.takenet.com.br.maraudersmap.model.LocalListener;
import maraudersmap.takenet.com.br.maraudersmap.util.PeopleLocationManager;

public class MaraudersMapApplication extends Application implements LocalListener{


    private static Context context;
    private static Local local;

    public static Context getContext(){
        return context;
    }
    public static Local getLocal(){
        return local;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        Firebase.setAndroidContext(this);

        LocalDao.getLocal(this);

    }

    @Override
    public void onLoad(Local value) {
        boolean callModifyLocation = local == null;
        this.local = value;
        if(callModifyLocation){
            PeopleLocationManager.modifyLocation();
        }

    }
}
