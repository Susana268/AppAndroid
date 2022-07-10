package com.sgonzalez.myapppoema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityPreco extends AppCompatActivity {
    private Button buttonRetPreco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_preco);
        buttonRetPreco = findViewById(R.id.btnReturnPreco);
        this.click();
    }
    private void click(){
        buttonRetPreco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionActivity();
            }
        });
    }
    private void actionActivity(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}