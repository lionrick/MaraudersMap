package maraudersmap.takenet.com.br.maraudersmap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import maraudersmap.takenet.com.br.maraudersmap.model.Pessoa;
import maraudersmap.takenet.com.br.maraudersmap.model.PessoaDao;
import maraudersmap.takenet.com.br.maraudersmap.util.NetWorkUtil;
import maraudersmap.takenet.com.br.maraudersmap.util.ProfileUtil;
import maraudersmap.takenet.com.br.maraudersmap.util.SharedPreferencesHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        persistData();

       /* Firebase myFirebaseRef = new Firebase("https://maraudersmapp.firebaseio.com/"); //just a test
        myFirebaseRef.child("message").setValue("Do you have data? You'll love Firebase.");*/
    }

    private void persistData() {

        String name = SharedPreferencesHelper.read(this, "mapa", "pessoa", "");

        if (name == null || !name.isEmpty()) {
            Pessoa p = new Pessoa();
            name = ProfileUtil.getName();
            p.setMacAddress(NetWorkUtil.getMacAddress());
            p.setNome(name);
            PessoaDao.create(p);
            SharedPreferencesHelper.write(this, "mapa", "pessoa", name);

        } else {
            return;
        }


    }
}
