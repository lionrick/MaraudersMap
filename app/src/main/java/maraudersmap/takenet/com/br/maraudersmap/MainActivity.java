package maraudersmap.takenet.com.br.maraudersmap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import maraudersmap.takenet.com.br.maraudersmap.model.Local;
import maraudersmap.takenet.com.br.maraudersmap.model.LocalListener;
import maraudersmap.takenet.com.br.maraudersmap.model.Pessoa;
import maraudersmap.takenet.com.br.maraudersmap.model.PessoaDao;
import maraudersmap.takenet.com.br.maraudersmap.model.PessoaListener;
import maraudersmap.takenet.com.br.maraudersmap.util.NetWorkUtil;
import maraudersmap.takenet.com.br.maraudersmap.util.ProfileUtil;
import maraudersmap.takenet.com.br.maraudersmap.util.SharedPreferencesHelper;

public class MainActivity extends AppCompatActivity implements LocalListener, PessoaListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        persistData();
    }

    private void persistData() {

        String name = SharedPreferencesHelper.read(this, "mapa", "pessoa", "");

        if (name == null || !name.isEmpty()) {
            Pessoa p = new Pessoa(ProfileUtil.getName(), NetWorkUtil.getMacAddress());
            PessoaDao.insert(p);
            SharedPreferencesHelper.write(this, "mapa", "pessoa", name);

        } else {
            return;
        }

    }

    @Override
    public void onLoad(Local local) {
        System.out.println(local.getNome());
    }

    @Override
    public void onLoadList(List<Pessoa> listaPessoas) {
        System.out.println(listaPessoas.size());
    }
}
