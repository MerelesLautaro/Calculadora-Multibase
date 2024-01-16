package com.lautadev.CalcPro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    private int itemId;
    private String tipoOperacion;
    private EditText vistaEquivalentes;
    private TextView vistaResultadoEquivalentes;
    private Button btnAccionDeterminar;
    private EditText vistaLongSim;
    private TextView vistaResultadoLongSim;
    private Button btnAccionCalcular;

    public void cambiarActivityPrincipal(View view){
        Intent anterior = new Intent(this, MainActivity.class);
        anterior.putExtra("tipo_operacion", tipoOperacion);
        startActivity(anterior);
    }

    public void cambiarActivity(View view){
        Intent siguiente = new Intent(this, MainActivity2.class);
        startActivity(siguiente);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        vistaEquivalentes = findViewById(R.id.inputEquivalentes);
        vistaResultadoEquivalentes = findViewById(R.id.resultadoEquivalente);
        btnAccionDeterminar = findViewById(R.id.btnDeterminar);

        vistaLongSim  = findViewById(R.id.inputLongYsimbolos);
        vistaResultadoLongSim = findViewById(R.id.resultadoLongYsimbolos);
        btnAccionCalcular = findViewById(R.id.btnCalcularLyS);

        // Crear opciones para los Spinners
        Spinner spinnerEquivalentes = findViewById(R.id.equivalentesUno);
        String[] equivalenteItems = {"Binario", "Octal", "Decimal", "Hexadecimal"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.spinner_item, equivalenteItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEquivalentes.setAdapter(adapter);

        Spinner spinnerAequivalentesDos = findViewById(R.id.aEquivalentesDos);
        spinnerAequivalentesDos.setAdapter(adapter);

        Spinner spinnerOpcionesLongSim = findViewById(R.id.longitudYsimbolos);
        String[] itemsLongSim = {"Longitud", "Simbolos"};
        ArrayAdapter<String> adapterLongSim = new ArrayAdapter<>(this,R.layout.spinner_item, itemsLongSim);
        adapterLongSim.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOpcionesLongSim.setAdapter(adapterLongSim);

        // Manejar el evento del botón
        btnAccionDeterminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el valor ingresado en el EditText
                String valorIngresado = vistaEquivalentes.getText().toString();

                // Obtener los tipos seleccionados en los Spinners
                String tipoEntrada = spinnerEquivalentes.getSelectedItem().toString();
                String tipoSalida = spinnerAequivalentesDos.getSelectedItem().toString();

                // Realizar la conversión
                String resultado = convertirValor(valorIngresado, tipoEntrada, tipoSalida);

                // Mostrar el resultado en el TextView
                vistaResultadoEquivalentes.setText(resultado);
            }
        });

        btnAccionCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el valor ingresado en el EditText
                String valorIngresado = vistaLongSim.getText().toString();

                // Obtener la opción seleccionada en el Spinner
                String tipoCalculo = spinnerOpcionesLongSim.getSelectedItem().toString();

                // Realizar el cálculo
                String resultado = realizarCalculo(valorIngresado, tipoCalculo);

                // Mostrar el resultado en el TextView
                vistaResultadoLongSim.setText(resultado);
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        updateTitle("Conversor");
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
        } else if (itemId == R.id.act_resolvente){
            cambiarActivity(null);
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

    private String convertirValor(String valor, String tipoEntrada, String tipoSalida) {
        try {
            switch (tipoEntrada) {
                case "Binario":
                    return convertirBinario(valor, tipoSalida);
                case "Octal":
                    return convertirOctal(valor, tipoSalida);
                case "Decimal":
                    return convertirDecimal(valor, tipoSalida);
                case "Hexadecimal":
                    return convertirHexadecimal(valor, tipoSalida);
                default:
                    return "Tipo de entrada no válido";
            }
        } catch (NumberFormatException e) {
            return "Verifique los valores ingresados. Ingrese números válidos.";
        }
    }

    private String convertirBinario(String valor, String tipoSalida) {
        int decimal = Integer.parseInt(valor, 2);
        return convertirDecimal(decimal, tipoSalida);
    }

    private String convertirOctal(String valor, String tipoSalida) {
        int decimal = Integer.parseInt(valor, 8);
        return convertirDecimal(decimal, tipoSalida);
    }

    private String convertirDecimal(String valor, String tipoSalida) {
        int decimal = Integer.parseInt(valor);
        return convertirDecimal(decimal, tipoSalida);
    }

    private String convertirHexadecimal(String valor, String tipoSalida) {
        int decimal = Integer.parseInt(valor, 16);
        return convertirDecimal(decimal, tipoSalida);
    }

    private String convertirDecimal(int decimal, String tipoSalida) {
        switch (tipoSalida) {
            case "Binario":
                return Integer.toBinaryString(decimal);
            case "Octal":
                return Integer.toOctalString(decimal);
            case "Decimal":
                return String.valueOf(decimal);
            case "Hexadecimal":
                return Integer.toHexString(decimal);
            default:
                return "Tipo de salida no válido";
        }
    }

    private String realizarCalculo(String valor, String tipoCalculo) {
        try {
            int valorNumerico = Integer.parseInt(valor);

            if (tipoCalculo.equals("Longitud")) {
                // Calcular la longitud del patrón de bits para un número de símbolos
                int longitud = (int) Math.ceil(Math.log(valorNumerico) / Math.log(2));
                return "Longitud del patrón de bits: " + longitud;
            } else if (tipoCalculo.equals("Simbolos")) {
                // Calcular el número de símbolos para una longitud de patrón de bits
                int simbolos = (int) Math.pow(2, valorNumerico);
                return "Número de símbolos: " + simbolos;
            } else {
                return "Opción no válida";
            }
        } catch (NumberFormatException e) {
            return "Verifique los valores ingresados. Ingrese números válidos.";
        }
    }
}
