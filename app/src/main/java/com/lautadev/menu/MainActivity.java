package com.lautadev.menu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtTextoOperacion;
    private TextView txtVistaPreliminar;
    private boolean clickSignoSuma, clickSignoResta, clickSignoDivision, clickSignoMultiplicacion, clickSignoDecimal;

    private void resetOperadores() {
        clickSignoSuma = false;
        clickSignoResta = false;
        clickSignoDivision = false;
        clickSignoMultiplicacion = false;
        clickSignoDecimal = false;
    }

    private void manejarOperador(String operador, boolean indicador) {
        String textoActual = txtTextoOperacion.getText().toString();

        if (textoActual.length() > 0 || operador.equals("-") && !clickSignoSuma && !clickSignoMultiplicacion && !clickSignoDivision) {
            char ultimoCaracter = textoActual.charAt(textoActual.length() - 1);
            if (ultimoCaracter == '+' || ultimoCaracter == '-' || ultimoCaracter == 'x' || ultimoCaracter == '/' || ultimoCaracter == ','){
                textoActual = textoActual.substring(0, textoActual.length() - 1);
                txtTextoOperacion.setText(textoActual + operador);
            }

            if (!indicador) {
                txtTextoOperacion.setText(textoActual + operador);
                switch (operador) {
                    case "+":
                        clickSignoSuma = true;
                        break;
                    case "-":
                        clickSignoResta = true;
                        break;
                    case "/":
                        clickSignoDivision = true;
                        break;
                    case "x":
                        clickSignoMultiplicacion = true;
                        break;
                    case ",":
                        clickSignoDecimal = true;
                        break;
                }
            }
        } else {
            txtTextoOperacion.setText("0" + operador);
            clickSignoDecimal = true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTextoOperacion = findViewById(R.id.txtOperacion);
        txtTextoOperacion.setFocusable(true);
        txtTextoOperacion.setFocusableInTouchMode(true);
        txtTextoOperacion.setInputType(InputType.TYPE_NULL);

        txtVistaPreliminar = findViewById(R.id.txtVistaPreliminar);
        txtVistaPreliminar.setFocusable(true);
        txtVistaPreliminar.setFocusableInTouchMode(true);
        txtVistaPreliminar.setInputType(InputType.TYPE_NULL);

        Button btnButtonDelete = findViewById(R.id.btnDelete);
        Button btnButtonCero = findViewById(R.id.btnCero);
        Button btnButtonUno = findViewById(R.id.btnUno);
        Button btnButtonDos = findViewById(R.id.btnDos);
        Button btnButtonTres = findViewById(R.id.btnTres);
        Button btnButtonCuatro = findViewById(R.id.btnCuatro);
        Button btnButtonCinco = findViewById(R.id.btnCinco);
        Button btnButtonSeis = findViewById(R.id.btnSeis);
        Button btnButtonSiete = findViewById(R.id.btnSiete);
        Button btnButtonOcho = findViewById(R.id.btnOcho);
        Button btnButtonNueve = findViewById(R.id.btnNueve);
        Button btnButtonA = findViewById(R.id.btnA);
        Button btnButtonB = findViewById(R.id.btnB);
        Button btnButtonC = findViewById(R.id.btnC);
        Button btnButtonD = findViewById(R.id.btnD);
        Button btnButtonE = findViewById(R.id.btnE);
        Button btnButtonF = findViewById(R.id.btnF);
        Button btnButtonSuma = findViewById(R.id.btnSuma);
        Button btnButtonResta = findViewById(R.id.btnResta);
        Button btnButtonDivision = findViewById(R.id.btnDivision);
        Button btnButtonMultiplicacion = findViewById(R.id.btnMultiplicacion);
        Button btnButtonDecimal = findViewById(R.id.btnComa);
        Button btnButtonIgual = findViewById(R.id.btnIgual);

        btnButtonDelete.setOnClickListener(v -> {
            String textoActual = txtTextoOperacion.getText().toString();
            if (textoActual.length() > 0) {
                String nuevoTexto = textoActual.substring(0, textoActual.length() - 1);
                txtTextoOperacion.setText(nuevoTexto);
                resetOperadores();
            }
        });


        btnButtonSuma.setOnClickListener(v -> manejarOperador("+", clickSignoSuma));
        btnButtonResta.setOnClickListener(v -> manejarOperador("-", clickSignoResta));
        btnButtonDivision.setOnClickListener(v -> manejarOperador("/", clickSignoDivision));
        btnButtonMultiplicacion.setOnClickListener(v -> manejarOperador("x", clickSignoMultiplicacion));
        btnButtonDecimal.setOnClickListener(v -> manejarOperador(",", clickSignoDecimal));

        // Crear un método genérico para manejar el clic en los botones
        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button clickedButton = (Button) v;
                String txtAnterior = txtTextoOperacion.getText().toString();
                String nuevoTexto = getResources().getString(R.string.texto_operacion_placeholder, txtAnterior + clickedButton.getText().toString());
                txtTextoOperacion.setText(nuevoTexto);
                resetOperadores();
            }
        };

        // Asignar el mismo Listener a múltiples botones
        btnButtonCero.setOnClickListener(buttonClickListener);
        btnButtonUno.setOnClickListener(buttonClickListener);
        btnButtonDos.setOnClickListener(buttonClickListener);
        btnButtonTres.setOnClickListener(buttonClickListener);
        btnButtonCuatro.setOnClickListener(buttonClickListener);
        btnButtonCinco.setOnClickListener(buttonClickListener);
        btnButtonSeis.setOnClickListener(buttonClickListener);
        btnButtonSiete.setOnClickListener(buttonClickListener);
        btnButtonOcho.setOnClickListener(buttonClickListener);
        btnButtonNueve.setOnClickListener(buttonClickListener);
        btnButtonA.setOnClickListener(buttonClickListener);
        btnButtonB.setOnClickListener(buttonClickListener);
        btnButtonC.setOnClickListener(buttonClickListener);
        btnButtonD.setOnClickListener(buttonClickListener);
        btnButtonE.setOnClickListener(buttonClickListener);
        btnButtonF.setOnClickListener(buttonClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Obtener el id del elemento del menú seleccionado
        int id = item.getItemId();

        // Verificar qué opción se ha seleccionado y actualizar el título del menú OPERACIONES
        if (id == R.id.act_binario) {
            updateTitle(getString(R.string.binario));
            return true;
        } else if (id == R.id.act_octal) {
            updateTitle(getString(R.string.octal));
            return true;
        } else if (id == R.id.act_decimal) {
            updateTitle(getString(R.string.decimal));
            return true;
        } else if (id == R.id.act_hexadecimal) {
            updateTitle(getString(R.string.hexadecimal));
            return true;
        } else if (id == R.id.act_resolvente) {
            updateTitle(getString(R.string.resolvente));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Método para actualizar el título del menú OPERACIONES
    private void updateTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }



}