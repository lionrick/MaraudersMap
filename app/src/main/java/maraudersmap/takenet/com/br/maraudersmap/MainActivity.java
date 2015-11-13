package maraudersmap.takenet.com.br.maraudersmap;

import android.animation.Animator;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

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

    private FrameLayout containerPeople;
    private TextView txtNumeroPessoas;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        containerPeople = (FrameLayout) findViewById(R.id.containerPeople);
        progress = (ProgressBar) findViewById(R.id.progress);
        txtNumeroPessoas = (TextView) findViewById(R.id.txtNumeroPessoas);
        persistData();
        PessoaDao.getLisPessoas(this);


        /*ImageView image = (ImageView) findViewById(R.id.dog);
        animateView(image, 0, 0);*/
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
        //intanciate the ghost if empty
        progress.setVisibility(View.GONE);
        txtNumeroPessoas.setText(listaPessoas.size()+"");
        containerPeople.removeAllViews();
        for (Pessoa pessoa : listaPessoas) {


            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v =  inflater.inflate(R.layout.item_pessoa_component, null);

            ImageView img = (ImageView) v.findViewById(R.id.imgPessoa);
            img.setImageResource(R.drawable.dog_front);


            TextView text = (TextView) v.findViewById(R.id.txtNome);
            text.setText(pessoa.getNome());
            containerPeople.addView(v);
            animateView(img,v, 0, 0);

        }


    }


    private void animateView(final ImageView img, final View view, int translationX, int translationY) {
        int distance = 100; //the distance to move in pixels
        int duration = 1500; //the duration of the animation in ms

        double direction = Math.random() * 2 * Math.PI;
        int sin = (int) (Math.sin(direction) * distance);
        int cos = (int) (Math.cos(direction) * distance);

        translationX += cos;
        translationY += sin;


        if (translationX < 0) {
            translationX = 0;
        }

        if (translationY < 0) {
            translationY = 0;
        }

        if(translationX > (getWidthScreen()-200)){
            translationX = getWidthScreen();
        }

        if (translationY > (getHeightScreen()-100)){
            translationY = getHeightScreen();
        }



        if (Math.cos(direction) > Math.cos(45)) {
            img.setImageResource(R.drawable.foot_print_right);
        }

        if (Math.cos(direction) < Math.cos(135)) {
            img.setImageResource(R.drawable.foot_print_left);
        }

        if (Math.cos(direction) < Math.cos(45) && Math.cos(direction) > Math.cos(135)) {
            if (Math.sin(direction) > 0) {
                img.setImageResource(R.drawable.foot_print_bottom);
            } else {
                img.setImageResource(R.drawable.foot_print_top);

            }
        }

        final int finalTranslationY = translationY;
        final int finalTranslationX = translationX;
        view.animate().translationX(translationX).translationY(translationY).setDuration(duration).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                animateView(img, view, finalTranslationX, finalTranslationY);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        }).start();
    }

    private int getHeightScreen(){

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        return  metrics.heightPixels;

    }

    private int getWidthScreen(){
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        return  metrics.widthPixels;
    }



}
