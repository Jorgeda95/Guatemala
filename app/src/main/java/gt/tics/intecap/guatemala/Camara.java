package gt.tics.intecap.guatemala;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by programadormd on 29/03/16.
 */
public class Camara extends Activity implements View.OnClickListener {

    private static  final int CAMARA_DATA = 0;
    private ImageView imageView;
    private ImageButton imageButton;
    private Button boton;
    private Bitmap bmp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo);

        inciaVars();

        InputStream is = getResources().openRawResource(R.raw.android);
        bmp = BitmapFactory.decodeStream(is);

    }

    private void inciaVars() {



        imageView = (ImageView) findViewById(R.id.ivDevuelvePicture);
        imageButton = (ImageButton) findViewById(R.id.ibTomarPicture);
        boton = (Button) findViewById(R.id.bSetWallpaper);

        imageButton.setOnClickListener(this);
        boton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ibTomarPicture:
                Intent miIntento = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(
                        miIntento, CAMARA_DATA);
                break;
            case R.id.bSetWallpaper:

                WallpaperManager wm = WallpaperManager.getInstance(getApplicationContext());

                try {
                    wm.setResource(R.raw.android);

                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bundle cesta = data.getExtras();
            bmp = (Bitmap) cesta.get("data");
            imageView.setImageBitmap(bmp);
        }
    }
}
