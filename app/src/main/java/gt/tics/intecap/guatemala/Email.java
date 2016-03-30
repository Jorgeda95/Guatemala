package gt.tics.intecap.guatemala;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by programadormd on 29/03/16.
 */
public class Email extends Activity implements View.OnClickListener {

    private EditText correo, intro, nombre, hace, lee, come;
    private String sCorreo, sIntro, sNombre, sHace, sLee, sCome;
    private Button envia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.correo);

        inciciaVars();

    }

    private void inciciaVars() {

        correo = (EditText) findViewById(R.id.etEmail);
        intro = (EditText) findViewById(R.id.etIntro);
        nombre = (EditText) findViewById(R.id.etNombrePersona);
        hace = (EditText) findViewById(R.id.etGusta);
        lee = (EditText) findViewById(R.id.etGustaLeer);
        come = (EditText) findViewById(R.id.etGustaComer);
        envia = (Button) findViewById(R.id.button);
        envia.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        convertirEditTextACadena();

        String direcion_correo[] = {sCorreo};
        String mensaje = "Hola a todos, mi nombre es " + sNombre + " y quiero decir " + sIntro
                + " y lo que me gusta hacer es " + sHace + " y mi lectura favorita es  "
                + sLee + " ademas me gusta comer " + sCome ;

        Intent miIntento = new Intent(Intent.ACTION_SEND);
        miIntento.putExtra(Intent.EXTRA_EMAIL, direcion_correo);
        miIntento.putExtra(Intent.EXTRA_SUBJECT, "Android App");
        miIntento.setType("text/plain");
        miIntento.putExtra(Intent.EXTRA_TEXT, mensaje);
        startActivity(miIntento);


    }

    private void convertirEditTextACadena() {

        sCorreo = correo.getText().toString().trim();
        sIntro = intro.getText().toString().trim();
        sNombre = nombre.getText().toString().trim();
        sHace = hace.getText().toString().trim();
        sLee = lee.getText().toString().trim();
        sCome = come.getText().toString().trim();

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
