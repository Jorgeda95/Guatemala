package gt.tics.intecap.guatemala;


import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;

public class Splash extends Activity{

    private static final long TIEMPO =  6000;
    private MediaPlayer miCancion;

    @Override
    protected void onCreate(Bundle bd) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(bd);
        setContentView(R.layout.splash);


        MediaPlayer miCancion = MediaPlayer.create(Splash.this, R.raw.fuistetu);
        miCancion.start();

    Thread miHilo =new Thread(){
        @Override
        public void run() {
            try{

            sleep(TIEMPO);
        }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                Intent starpoint = new Intent("gt.tics.intecap.guatemala.MENU");
                startActivity(starpoint);
            }
        }
    };


        miHilo.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
        miCancion.release();


    }
}
