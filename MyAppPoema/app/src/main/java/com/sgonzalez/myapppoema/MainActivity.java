package com.sgonzalez.myapppoema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonPr;
    private Button buttonXVII;
    private Button buttonXX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonPr=findViewById(R.id.btnPreco);
        buttonXVII=findViewById(R.id.btnXVIII);
        buttonXX=findViewById(R.id.btnXX);
        this.click();
    }


    public void click(){
        buttonPr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionActivityPr();
            }
        });
        buttonXVII.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionActivityXVII();
            }
        });
        buttonXX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionActivityXX();
            }
        });

    }

    private void actionActivityPr(){
        Intent intent = new Intent(this,MainActivityPreco.class);
        startActivity(intent);
    }

    private void actionActivityXVII(){
        Intent intent = new Intent(this,MainActivityXVIII.class);
        startActivity(intent);
    }

    private void actionActivityXX(){
        Intent intent = new Intent(this,MainActivityXX.class);
        startActivity(intent);
    }

}