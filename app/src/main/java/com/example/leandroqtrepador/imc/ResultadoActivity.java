package com.example.leandroqtrepador.imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Intent intent = getIntent();
        String mensagem = intent.getStringExtra(MainActivity.Mensagem);
        TextView textoResultado = findViewById(R.id.tvResultado);
        textoResultado.setText(mensagem);
    }
}
