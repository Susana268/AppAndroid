package com.sgonzalez.myappsumar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    TextView txtValor1,txtValor2 ;
    EditText editTextResSuma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtValor1 = findViewById(R.id.txtValor1);
        txtValor2 = findViewById(R.id.txtValor2);
        final Random random= new Random();
        String randomNumber = String.valueOf(random.nextInt(99));
        txtValor1.setText(randomNumber);
        randomNumber = String.valueOf(random.nextInt(99));
        txtValor2.setText(randomNumber);
        editTextResSuma=findViewById(R.id.txtResSuma);
    }

    private void suma(){
        String valor1 = txtValor1.getText().toString();
        String valor2 = txtValor2.getText().toString();
        String resultadoN = editTextResSuma.getText().toString();

        if (!resultadoN.isEmpty()) {
            int valorResultadoN = Integer.parseInt(resultadoN);
            int v1 = Integer.parseInt(valor1);
            int v2 = Integer.parseInt(valor2);
            int r1 = v1 + v2;

            if (r1 == valorResultadoN ){
                Toast.makeText(this, "Calculo Correcto", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "Necesita Estudiar Mas", Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(this, "Los datos no fueron Ingresados", Toast.LENGTH_SHORT).show();
        }
    }

    private void retornaSuma(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onClick(View view){
        switch(view.getId()) {
            case R.id.btnSuma:
                this.suma();
                break;
            case R.id.btnRetSuma:
                this.retornaSuma();
                break;
        }
    }
}