package com.example.buttonactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagen =(ImageView) findViewById(R.id.imageView);
        imagen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Realice Click en Estrella", Toast.LENGTH_LONG).show();
            }
        });
    }
    public void eventoBoton(View view){
        Toast.makeText(this, "Realice Click", Toast.LENGTH_LONG).show();
    }

    public void eventoBotonMinion(View view){
        Toast.makeText(this, "Realice Click al Minion", Toast.LENGTH_LONG).show();
    }

    public void eventoSiguiente(View view){
        Intent Siguiente = new Intent(this, SegundoActivity.class);
        startActivity(Siguiente);
    }
}
