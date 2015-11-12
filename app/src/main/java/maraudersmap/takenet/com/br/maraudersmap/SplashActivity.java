package maraudersmap.takenet.com.br.maraudersmap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.firebase.client.Firebase;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

       /* Firebase myFirebaseRef = new Firebase("https://maraudersmapp.firebaseio.com/"); //just a test
        myFirebaseRef.child("message").setValue("Do you have data? You'll love Firebase.");*/
    }
}
