package com.sgonzalez.myapppoema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityXVIII extends AppCompatActivity {
    private Button buttonRetXVIII;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_xviii);
        buttonRetXVIII = findViewById(R.id.btnReturnXVIII);
        this .click();
    }
    private void click(){
        buttonRetXVIII.setOnClickListener(new View.OnClickListener() {
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