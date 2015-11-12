package maraudersmap.takenet.com.br.maraudersmap.model;

import com.firebase.client.Firebase;

public class PessoaDao {

    public static void create(Pessoa p){
        Firebase myFirebaseRef = new Firebase("https://maraudersmapp.firebaseio.com/");
        myFirebaseRef.child("pessoas").setValue(p);
    }

}
