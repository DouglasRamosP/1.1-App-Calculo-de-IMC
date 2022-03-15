package com.example.mdiad;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtPeso;
    EditText edtAltura;
    Button btnVerificar;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carregaComponentes();
        configurarBotaoVerificar();
    }

    protected void carregaComponentes() {
        edtAltura = findViewById(R.id.edtAltura);
        edtPeso = findViewById(R.id.edtPeso);
        btnVerificar = findViewById(R.id.btnVerificar);
        txtResultado = findViewById(R.id.txtResultado);
    }

    protected void configurarBotaoVerificar() {
        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resultado = realizaCalculo();
                exibiResultado(resultado);
                limpaCampos();
            }
        });
    }

    protected String realizaCalculo() {
        double peso = Double.parseDouble(edtPeso.getText().toString());
        double altura = Double.parseDouble(edtAltura.getText().toString());
        double res = peso/(altura*altura);
        String resultado = "Obesidade Grau IIII (mórbida)";
        if (res < 16) {
            resultado = "Magreza grave";
        }
        else if (res == 16 ) {
            resultado = "Magreza moderada";
        }
        else if (res > 15 && res < 18.5 ) {
            resultado = "Magreza leve";
        }
        else if (res > 18.4 && res < 25 ) {
            resultado = "Saudável";
        }
        else if (res > 25 && res < 30 ) {
            resultado = "Sobrepeso";
        }
        else if (res > 30 && res < 35 ) {
            resultado = "Obesidade Grau 1";
        }
        else if (res > 35 && res < 40 ) {
            resultado = "Obesidade Grau II";
        }
        return resultado;
    }

    protected void exibiResultado(String resultado) {
        txtResultado.setText(resultado);
    }

    protected void limpaCampos() {
        edtAltura.setText("");
        edtPeso.setText("");

        edtPeso.requestFocus();
        edtAltura.requestFocus();


    }
}