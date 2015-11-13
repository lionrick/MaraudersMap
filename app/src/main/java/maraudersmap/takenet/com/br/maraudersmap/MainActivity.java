package maraudersmap.takenet.com.br.maraudersmap;

import android.animation.Animator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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
            PessoaDao.insert(p);
            SharedPreferencesHelper.write(this, "mapa", "pessoa", name);

        } else {
            return;
        }


    }


    private void animateView(final View view, int translationX, int translationY ) {
        int distance = 100; //the distance to move in pixels
        int duration = 1000; //the duration of the animation in ms

        double direction = Math.random() * 2 * Math.PI;

        translationX += (int) (Math.cos(direction) * distance);
        translationY += (int) (Math.sin(direction) * distance);

        if(translationX<0){
            translationX = 0 ;
        }

        if(translationY<0){
            translationY = 0;
        }

        final int finalTranslationY = translationY;
        final int finalTranslationX = translationX;
        view.animate().translationX(translationX).translationY(translationY).setDuration(duration).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                System.out.println("x"+finalTranslationX+" y"+finalTranslationY);
                animateView(view, finalTranslationX, finalTranslationY);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        }).start();
    }
}
