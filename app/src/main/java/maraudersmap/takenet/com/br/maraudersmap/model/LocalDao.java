package maraudersmap.takenet.com.br.maraudersmap.model;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class LocalDao {

    public static void create(Local l){
        Firebase myFirebaseRef = new Firebase("https://maraudersmapp.firebaseio.com/");
        myFirebaseRef.child("Local").setValue(l);
    }

    public static void getLocal(final LocalListener listener){
        final Firebase myFirebaseRef = new Firebase("https://maraudersmapp.firebaseio.com/Local");
        myFirebaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listener.onLoad((Local) dataSnapshot.getValue(Local.class));
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
