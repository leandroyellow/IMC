package com.example.leandroqtrepador.imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public static final String Mensagem = "com.example.imccal.Mensagem";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculo_imc (View view){
        EditText Peso = findViewById(R.id.txtPeso);
        EditText Altura = findViewById(R.id.txtAltura);

        TextView IMC = findViewById(R.id.tvIMC);


        if (Peso.getText().toString().isEmpty() || Altura.getText().toString().isEmpty()) {
            IMC.setText("valor invalido");
        }
        else{

            Double massa = Double.parseDouble(Peso.getText().toString());
            Double H = Double.parseDouble(Altura.getText().toString());
            Double Calculo_IMC = massa / (H * H);
            IMC.setText("Resultado: " + String.format("%.2f", Calculo_IMC));
            resultado_imc(Calculo_IMC);
        }
        Peso.setText("");
        Altura.setText("");




    }
    public void resultado_imc (Double IMC){
        TextView Resultado = findViewById(R.id.tvResultado);
        String res;
        if (IMC < 16){
            Resultado.setText("Magreza grave");
            res = "Magreza grave";
        }
        else if (IMC < 17){
            Resultado.setText("Magreza moderada");
            res = "Magreza moderada";
        }
        else if (IMC < 18.5){
            Resultado.setText("Magreza leve");
            res = "Magreza leve";
        }
        else if (IMC < 25){
            Resultado.setText("Saudável");
            res = "Saudável";
        }
        else if (IMC < 30){
            Resultado.setText("Sobrepeso");
            res = "Sobrepeso";
        }
        else if (IMC < 35){
            Resultado.setText("Obesidade grau 1");
            res = "Obesidade grau 1";
        }
        else if (IMC < 40){
            Resultado.setText("Obesidade grau 2 Severa");
            res = "Obesidade grau 2 Severa";
        }
        else{
            Resultado.setText("Obesidade grau 3 Mórbida");
            res = "Obesidade grau 3 Mórbida";
        }



        Intent intent = new Intent(this, ResultadoActivity.class);
        intent.putExtra(Mensagem, "Olá!!! Seu IMC é igual a " + String.format("%.2f", IMC) + " \nvocê está com " + res );
        startActivity(intent);

    }
}
