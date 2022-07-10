package com.sgonzalez.myappsumar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity3 extends AppCompatActivity {
    TextView txtValor3,txtValor4;
    EditText editTextResMulti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        txtValor3 = findViewById(R.id.txtValor3);
        txtValor4 = findViewById(R.id.txtValor4);
        final Random random= new Random();
        String randomNumber = String.valueOf(random.nextInt(99));
        txtValor3.setText(randomNumber);
        randomNumber = String.valueOf(random.nextInt(99));
        txtValor4.setText(randomNumber);
        editTextResMulti=findViewById(R.id.txtResMulti);
    }

    private void multi (){
        String valor3 = txtValor3.getText().toString();
        String valor4 = txtValor4.getText().toString();
        String resultadoA = editTextResMulti.getText().toString();
        if (!resultadoA.isEmpty()) {
            int valorResultadoA = Integer.parseInt(resultadoA);
            int v3 = Integer.parseInt(valor3);
            int v4 = Integer.parseInt(valor4);
            int r2 = v3 * v4;

            if (r2 == valorResultadoA) {
                Toast.makeText(this, "Calculo Correcto", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Necesita Estudiar Mas", Toast.LENGTH_LONG).show();
            }
        }else {
            Toast.makeText(this, "Los datos no fueron ingresados", Toast.LENGTH_LONG).show();
        }
    }

    private void retornaMulti(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onClick(View view){
        switch(view.getId()) {
            case R.id.btnMulti:
                this.multi();
                break;
            case R.id.btnRetMulti:
                this.retornaMulti();
                break;
        }
    }
}