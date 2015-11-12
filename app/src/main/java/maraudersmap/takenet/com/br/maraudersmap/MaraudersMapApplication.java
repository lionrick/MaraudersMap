package maraudersmap.takenet.com.br.maraudersmap;

import android.app.Application;
import android.content.Context;

import com.firebase.client.Firebase;

public class MaraudersMapApplication extends Application {


    private static Context context;

    public static Context getContext(){
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        Firebase.setAndroidContext(this);
    }
}
