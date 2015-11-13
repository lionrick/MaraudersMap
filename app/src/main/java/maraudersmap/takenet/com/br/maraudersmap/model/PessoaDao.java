package maraudersmap.takenet.com.br.maraudersmap.model;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PessoaDao {

    public static void insert(Pessoa p){
        Firebase myFirebaseRef = new Firebase("https://maraudersmapp.firebaseio.com/Local");
        myFirebaseRef.child("pessoas").child(p.getMacAddress()).setValue(p);
    }

    public static void remove(String mac){
        Firebase myFirebaseRef = new Firebase("https://maraudersmapp.firebaseio.com/Local/pessoas");
        myFirebaseRef.child(mac).removeValue();
    }

    public static void getLisPessoas(final PessoaListener listener){
        final Firebase myFirebaseRef = new Firebase("https://maraudersmapp.firebaseio.com/Local/pessoas");
        myFirebaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    Pessoa p = postSnapshot.getValue(Pessoa.class);
                    listaPessoas.add(p);
                }
                listener.onLoadList(listaPessoas);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }


}
