package com.sgonzalez.mycalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNum1,editTextNum2;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNum1=findViewById(R.id.valor1);
        editTextNum2=findViewById(R.id.valor2);
        textViewResultado = findViewById(R.id.txtResultado);
    }

    private void suma(){
        String num1 = editTextNum1.getText().toString();
        String num2= editTextNum2.getText().toString();
        if(!num1.isEmpty()&&!num2.isEmpty()){
            double sumar= Double.parseDouble(num1)+Double.parseDouble(num2);
            textViewResultado.setText(String.valueOf(sumar));
        }else {
            Toast.makeText(this, "Datos no Ingresados", Toast.LENGTH_SHORT).show();
        }

    }

    private void resta(){
        String num1 = editTextNum1.getText().toString();
        String num2= editTextNum2.getText().toString();
        if(!num1.isEmpty()&&!num2.isEmpty()){
            double restar= Double.parseDouble(num1)-Double.parseDouble(num2);
            textViewResultado.setText(String.valueOf(restar));
        }else {
            Toast.makeText(this, "Datos no Ingresados", Toast.LENGTH_SHORT).show();
        }
    }

    private void multiplica(){
        String num1 = editTextNum1.getText().toString();
        String num2= editTextNum2.getText().toString();
        if(!num1.isEmpty()&&!num2.isEmpty()){
            double multiplicar= Double.parseDouble(num1)*Double.parseDouble(num2);
            textViewResultado.setText(String.valueOf(multiplicar));
        }else {
            Toast.makeText(this, "Datos no Ingresados", Toast.LENGTH_SHORT).show();
        }
    }
    private void divide(){
        String num1 = editTextNum1.getText().toString();
        String num2= editTextNum2.getText().toString();
        if(!num1.isEmpty()&&!num2.isEmpty()) {
            if (!(Double.parseDouble(num2) == (0))) {
                double dividir = Double.parseDouble(num1) / Double.parseDouble(num2);
                textViewResultado.setText(String.valueOf(dividir));
            }else{
                Toast.makeText(this, "Division por Cero", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this, "Datos no Ingresados", Toast.LENGTH_SHORT).show();
        }
    }

    public  void  onClick(View view){
        switch(view.getId()){
            case R.id.btnSuma:
                this.suma();
                break;
            case R.id.btnResta:
                this.resta();
                break;
            case R.id.btnMultiplica:
                this.multiplica();
                break;
            case R.id.btnDivide:
                this.divide();
                break;
        }
    }
}