package com.lautadev.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    private int itemId;
    private String tipoOperacion;

    private EditText txtValorA;
    private EditText txtValorB;
    private EditText txtValorC;
    private Button btnButtonCalcular;
    private TextView txtVistaResultadoResolvente;
    public void cambiarActivityPrincipal(View view){
        Intent anterior = new Intent(this, MainActivity.class);
        anterior.putExtra("tipo_operacion", tipoOperacion);
        startActivity(anterior);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setContentView(R.layout.activity_main2);

        txtValorA = findViewById(R.id.inputValorA);
        txtValorB = findViewById(R.id.inputValorB);
        txtValorC = findViewById(R.id.inputValorC);
        btnButtonCalcular = findViewById(R.id.btnCalcularResolvente);
        txtVistaResultadoResolvente = findViewById(R.id.resultadoResolvente);


        btnButtonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para calcular las raíces y mostrar el resultado
                calcularResolvente();
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        updateTitle("Resolvente");
        return true;
    }

    private void updateTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        itemId = item.getItemId();
        if (itemId == R.id.act_binario || itemId == R.id.act_octal || itemId == R.id.act_decimal || itemId == R.id.act_hexadecimal ) {
            tipoOperacion = obtenerTipoOperacion(itemId);
            cambiarActivityPrincipal(null);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private String obtenerTipoOperacion(int itemId) {
        if(itemId == R.id.act_decimal){
            return "Decimal";
        } else if (itemId == R.id.act_binario){
            return "Binario";
        }else if (itemId == R.id.act_octal){
            return "Octal";
        }else if (itemId == R.id.act_hexadecimal){
            return "Hexadecimal";
        }
        return null;
    }

    private void calcularResolvente() {
        // Obtener valores ingresados por el usuario
        String valorAString = txtValorA.getText().toString();
        String valorBString = txtValorB.getText().toString();
        String valorCString = txtValorC.getText().toString();

        try {
            // Intentar convertir los valores a números
            double valorA = Double.parseDouble(valorAString);
            double valorB = Double.parseDouble(valorBString);
            double valorC = Double.parseDouble(valorCString);

            // Calcular las raíces
            double discriminante = Math.pow(valorB, 2) - 4 * valorA * valorC;

            if (discriminante >= 0) {
                double raiz1 = (-valorB + Math.sqrt(discriminante)) / (2 * valorA);
                double raiz2 = (-valorB - Math.sqrt(discriminante)) / (2 * valorA);

                // Mostrar el resultado en el TextView
                if (raiz1 == raiz2) {
                    // Raíces iguales
                    txtVistaResultadoResolvente.setText("Raíz única: " + raiz1);
                } else {
                    // Raíces diferentes
                    txtVistaResultadoResolvente.setText("Raíz 1: " + raiz1 + "\nRaíz 2: " + raiz2);
                }
            } else {
                // Calcular la parte real e imaginaria de las raíces imaginarias
                double parteReal = -valorB / (2 * valorA);
                double parteImaginaria = Math.sqrt(Math.abs(discriminante)) / (2 * valorA);

                // Mostrar el resultado en formato complejo
                txtVistaResultadoResolvente.setText("Raíz 1: " + parteReal + " + " + parteImaginaria + "i\n"
                        + "Raíz 2: " + parteReal + " - " + parteImaginaria + "i");
            }
        } catch (NumberFormatException e) {
            // Manejar el caso en el que la conversión a números falle
            txtVistaResultadoResolvente.setText("Verifique los valores ingresados. Ingrese números válidos.");
        }
    }

}