package maraudersmap.takenet.com.br.maraudersmap.model;

import com.firebase.client.Firebase;

public class PessoaDao {

    public static void insert(Pessoa p){
        Firebase myFirebaseRef = new Firebase("https://maraudersmapp.firebaseio.com/Local");
        myFirebaseRef.child("pessoas").child(p.getMacAddress()).setValue(p);
    }

    public static void remove(String mac){
        Firebase myFirebaseRef = new Firebase("https://maraudersmapp.firebaseio.com/Local/pessoas");
        myFirebaseRef.child(mac).removeValue();
    }


}
