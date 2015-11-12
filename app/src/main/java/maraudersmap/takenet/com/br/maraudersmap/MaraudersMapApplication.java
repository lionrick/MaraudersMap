package maraudersmap.takenet.com.br.maraudersmap;

import android.app.Application;

import com.firebase.client.Firebase;

public class MaraudersMapApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
