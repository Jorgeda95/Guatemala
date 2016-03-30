package gt.tics.intecap.guatemala;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

import java.util.Random;


public class TextoPlay extends Activity implements View.OnClickListener{

    private EditText entrada;
    private Button comando;
    private ToggleButton password;
    private TextView guate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.texto);

        iniciaVars();
    }

    private void iniciaVars() {

        entrada = (EditText) findViewById(R.id.etComando);
        comando = (Button) findViewById(R.id.bComando);
        password = (ToggleButton) findViewById(R.id.tb);
        guate = (TextView) findViewById(R.id.tvResultado);


        comando.setOnClickListener(this);
        password.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.bComando:

                String texto = entrada.getText().toString().toLowerCase().trim();

                if(texto.contentEquals("izquierda")){


                    entrada.setGravity(Gravity.LEFT);

                }else if(texto.contentEquals("centro")){

                    entrada.setGravity(Gravity.CENTER);

                }else if(texto.contentEquals("derecha")){

                    entrada.setGravity(Gravity.RIGHT);

                }else if(texto.contentEquals("azul")){

                    entrada.setTextColor(Color.BLUE);

                }else if(texto.contentEquals("hola")){

                    Random rand = new Random();
                    entrada.setText("Guate");
                    entrada.setTextSize(rand.nextInt(75));
                    entrada.setTextColor(Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));

                    switch(rand.nextInt(3)){

                        case 0:
                            entrada.setGravity(Gravity.LEFT);
                        break;

                        case 1:
                            entrada.setGravity(Gravity.CENTER);
                            break;
                        case 2:
                            entrada.setGravity(Gravity.RIGHT);
                            break;
                    }

                }

                break;

            case R.id.tb:

                if(password.isChecked()){

                    entrada.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

                }else{

                    entrada.setInputType(InputType.TYPE_CLASS_TEXT);

                }

                break;

        }


    }
}
