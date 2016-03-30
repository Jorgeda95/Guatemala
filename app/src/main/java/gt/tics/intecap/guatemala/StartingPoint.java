package gt.tics.intecap.guatemala;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StartingPoint extends Activity {

    private TextView mostrar;
    private Button agregar, restar, bsumar;
    private int contador;


    @Override
    protected void onCreate(Bundle bd) {
        super.onCreate(bd);
        //set content view es con lo que se asigna la vista del activity main
        // R(clase r adentro del paquite test) . layout. nombre del archivo xml, es la direccion
        setContentView(R.layout.activity_main);

        iniciaVars();
    }

    private void iniciaVars() {
        contador = 0;

        mostrar = (TextView) findViewById(R.id.tvMostrar);
        agregar  = (Button) findViewById(R.id.bAgregar);
        restar = (Button)findViewById(R.id.bRestar);




        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                contador++;
                mostrar.setText("El total es " + contador);


            }
        });



        restar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador--;
                mostrar.setText("El total es " + contador);
            }
        });


    }
}


/* modelo: base de datos
   vista: lo que se ve
   controlador: lo que contrala la vista
 */