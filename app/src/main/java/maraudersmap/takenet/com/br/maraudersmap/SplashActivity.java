package maraudersmap.takenet.com.br.maraudersmap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import maraudersmap.takenet.com.br.maraudersmap.model.Local;
import maraudersmap.takenet.com.br.maraudersmap.model.LocalDao;
import maraudersmap.takenet.com.br.maraudersmap.model.LocalListener;
import maraudersmap.takenet.com.br.maraudersmap.model.Pessoa;
import maraudersmap.takenet.com.br.maraudersmap.model.PessoaDao;
import maraudersmap.takenet.com.br.maraudersmap.model.PessoaListener;

public class SplashActivity extends AppCompatActivity implements LocalListener, PessoaListener {

    private static final int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        LocalDao.getLocal(this);
        PessoaDao.getLisPessoas(this);

/*        new Handler().postDelayed(new Runnable() {
            
            @Override
            public void run() {
             
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        }, SPLASH_TIME_OUT);*/

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
