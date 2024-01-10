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

    private Button[] buttonsToDisableHex;

    private Button[] buttonsToDisableBinario;

    private Button[] buttonsToDisableOctal;

    private String numeroActual = ""; // Variable para almacenar los números ingresados
    private String operador = ""; // Variable para almacenar el operador seleccionado
    private String primerNumero = ""; // Variable para almacenar el primer número

    private int itemId;

    private void manejarOperador(String operador) {
        if(numeroActual.isEmpty() && primerNumero.isEmpty()){
            this.operador = operador;
            numeroActual = "0";
            txtVistaPreliminar.setText("0" + operador);
        }
            if (!numeroActual.isEmpty()) {
            // Si hay un número actual, se guarda como el segundo número
            primerNumero = numeroActual;
            this.operador = operador;
            numeroActual = ""; // Se reinicia el número actual para el siguiente ingreso
            txtVistaPreliminar.setText(primerNumero + " " + operador); // Mostrar la operación en curso
            } else if (!primerNumero.isEmpty()){
            this.operador = operador;
            txtVistaPreliminar.setText(primerNumero+ " " + operador);
            numeroActual = "";
            }
    }

    private void manejarNumero(String numero) {
        numeroActual += numero;
        txtTextoOperacion.setText(numeroActual); // Mostrar los números ingresados
    }

    private String calcularResultado() {
        String resultado;
        String num1 = primerNumero;
        String num2 = numeroActual;

        if (itemId == R.id.act_decimal) {
            double valor1 = Double.parseDouble(num1);
            double valor2 = Double.parseDouble(num2);
            switch (operador) {
                case "+":
                    resultado = String.valueOf(Calculadora.sumar(valor1, valor2));
                    break;
                case "-":
                    resultado = String.valueOf(Calculadora.restar(valor1, valor2));
                    break;
                case "x":
                    resultado = String.valueOf(Calculadora.multiplicar(valor1, valor2));
                    break;
                case "/":
                    resultado = String.valueOf(Calculadora.dividir(valor1, valor2));
                    break;
                default:
                    resultado = "0"; // Manejar operador inválido, en este caso se devuelve 0
            }
        } else if (itemId == R.id.act_octal) {
            switch (operador) {
                case "+":
                    resultado = CalculadoraOctal.sumarOctal(num1, num2);
                    break;
                case "-":
                    resultado = CalculadoraOctal.restarOctal(num1, num2);
                    break;
                case "x":
                    resultado = CalculadoraOctal.multiplicarOctal(num1, num2);
                    break;
                case "/":
                    resultado = CalculadoraOctal.dividirOctal(num1, num2);
                    break;
                default:
                    resultado = "0"; // Manejar operador inválido, en este caso se devuelve 0
            }
            }else if (itemId == R.id.act_hexadecimal) {
            switch (operador) {
                case "+":
                    resultado = CalculadoraHex.sumarHex(num1, num2);
                    break;
                case "-":
                    resultado = CalculadoraHex.restarHex(num1, num2);
                    break;
                case "x":
                    resultado = CalculadoraHex.multiplicarHex(num1, num2);
                    break;
                case "/":
                    resultado = CalculadoraHex.dividirHex(num1, num2);
                    break;
                default:
                    resultado = "0"; // Manejar operador inválido, en este caso se devuelve 0
            }
            }else if (itemId == R.id.act_binario) {
            switch (operador) {
                case "+":
                    resultado = CalculadoraBinaria.sumarBi(num1, num2);
                    break;
                case "-":
                    resultado = CalculadoraBinaria.restarBi(num1, num2);
                    break;
                case "x":
                    resultado = CalculadoraBinaria.multiplicarBi(num1, num2);
                    break;
                case "/":
                    resultado = CalculadoraBinaria.dividirBi(num1, num2);
                    break;
                default:
                    resultado = "0"; // Manejar operador inválido, en este caso se devuelve 0
            }
            } else {
            // Manejo de otros casos o valores por defecto
            return "0";
            }
        return resultado;
    }
    private void funcionDelete() {
        if (!numeroActual.isEmpty()) {
            numeroActual = numeroActual.substring(0, numeroActual.length() - 1);
            txtTextoOperacion.setText(numeroActual);
        }
    }

    private void funcionLimpiarTodo(){
        txtTextoOperacion.setText("");
        txtVistaPreliminar.setText("");
        primerNumero = "";
        numeroActual = "";
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asignar variable a los botones mediante el ID
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

        btnButtonDelete.setOnClickListener(v -> funcionDelete());

        btnButtonIgual.setOnClickListener(v -> {
            if (!primerNumero.isEmpty() && !operador.isEmpty() && !numeroActual.isEmpty()) {
                String resultado = calcularResultado();
                txtTextoOperacion.setText(String.valueOf(resultado));
                txtVistaPreliminar.setText(""); // Limpiar la vista preliminar
                primerNumero = String.valueOf(resultado); // El resultado se convierte en el primer número para futuras operaciones
                numeroActual = ""; // Se reinicia el número actual
                operador = ""; // Se reinicia el operador
            }
        });


        btnButtonSuma.setOnClickListener(v -> manejarOperador("+"));
        btnButtonResta.setOnClickListener(v -> manejarOperador("-"));
        btnButtonDivision.setOnClickListener(v -> manejarOperador("/"));
        btnButtonMultiplicacion.setOnClickListener(v -> manejarOperador("x"));
        btnButtonDecimal.setOnClickListener(v -> manejarOperador(","));
        btnButtonDecimal.setOnClickListener(v -> {
            if (numeroActual.isEmpty()) {
                // Si no hay ningún número ingresado, muestra "0," en la pantalla
                numeroActual = "0";
            }
            if (!numeroActual.contains(".")) {
                // Verifica si ya hay un punto decimal
                numeroActual += ".";
                txtTextoOperacion.setText(numeroActual); // Muestra el número actualizado en la pantalla
            }
        });

        // Crear un método genérico para manejar el clic en los botones
        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button clickedButton = (Button) v;
                manejarNumero(clickedButton.getText().toString());
                //resetOperadores(); // Reiniciar los operadores al ingresar un número
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

        //Botones que se habilitan o desabilitan segun la operacion a realizar.
        buttonsToDisableHex = new Button[]{
                 btnButtonA, btnButtonB, btnButtonC,
                 btnButtonD, btnButtonE, btnButtonF, btnButtonDecimal
        };

        buttonsToDisableOctal= new Button[]{
                btnButtonA, btnButtonB, btnButtonC, btnButtonDecimal,
                btnButtonD, btnButtonE, btnButtonF, btnButtonNueve,
                btnButtonOcho
        };

        buttonsToDisableBinario = new Button[]{
                btnButtonA, btnButtonB, btnButtonC,
                btnButtonD, btnButtonE, btnButtonF,
                btnButtonDos, btnButtonTres, btnButtonCuatro,
                btnButtonCinco, btnButtonSeis, btnButtonSiete, btnButtonOcho,
                btnButtonNueve, btnButtonDecimal
        };

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        updateTitle(getString(R.string.decimal)); // Establecer por defecto en 'Decimal'
        itemId = R.id.act_decimal;
        enableButtons(buttonsToDisableHex, false); // Deshabilitar botones hexadecimales
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Obtener el id del elemento del menú seleccionado
        itemId = item.getItemId();
        // Resetear valor boleano de los numeros para que no halla problemas con variables globales
        enableButtonsBi(buttonsToDisableBinario,true);


        // Verificar qué opción se ha seleccionado y actualizar el título del menú OPERACIONES
        if (itemId == R.id.act_binario) {
            updateTitle(getString(R.string.binario));
            enableButtonsBi(buttonsToDisableBinario,false);
            funcionLimpiarTodo();
            return true;
        } else if (itemId == R.id.act_octal) {
            updateTitle(getString(R.string.octal));
            enableButtonsOctal(buttonsToDisableOctal, false);
            funcionLimpiarTodo();
            return true;
        } else if (itemId == R.id.act_decimal) {
            updateTitle(getString(R.string.decimal));
            enableButtons(buttonsToDisableHex,false);
            funcionLimpiarTodo();
            return true;
        } else if (itemId == R.id.act_hexadecimal) {
            updateTitle(getString(R.string.hexadecimal));
            enableButtons(buttonsToDisableHex,true);
            funcionLimpiarTodo();
            return true;
        } else if (itemId == R.id.act_resolvente) {
            updateTitle(getString(R.string.resolvente));
            enableButtons(buttonsToDisableHex,false);
            funcionLimpiarTodo();
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

    private void enableButtons(Button[] buttons, boolean isEnabled) {
        for (Button button : buttons) {
            button.setEnabled(isEnabled);
        }
    }

    private void enableButtonsBi(Button[] ignoredButtonsBi, boolean isEnabledBi) {
        for (Button buttons : buttonsToDisableBinario) {
            buttons.setEnabled(isEnabledBi);
        }
    }

    private void enableButtonsOctal(Button[] ignoredButtonsOctal, boolean isEnabledOctal) {
        for (Button buttons : buttonsToDisableOctal) {
            buttons.setEnabled(isEnabledOctal);
        }
    }

}