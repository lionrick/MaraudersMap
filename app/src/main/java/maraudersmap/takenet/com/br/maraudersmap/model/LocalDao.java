package maraudersmap.takenet.com.br.maraudersmap.model;

import com.firebase.client.Firebase;

public class LocalDao {

    public static void create(Local l){
        Firebase myFirebaseRef = new Firebase("https://maraudersmapp.firebaseio.com/");
        myFirebaseRef.child("Local").setValue(l);
    }
}
