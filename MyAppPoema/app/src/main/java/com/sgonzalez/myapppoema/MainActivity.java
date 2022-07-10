package com.sgonzalez.myapppoema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonPr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonPr=findViewById(R.id.btnPreco);
        this.click();
    }


    public void click(){
        buttonPr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionActivity();
            }
        });

    }

    private void actionActivity(){
        Intent intent = new Intent(this,MainActivityPreco.class);
        startActivity(intent);
    }





}