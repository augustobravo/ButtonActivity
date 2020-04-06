package com.example.buttonactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class SegundoActivity extends AppCompatActivity {

    private EditText txtNombre, txtPassword, txtCorreo;
    private CheckBox chTeatro, chCine, chCena;
    private RadioButton rbMasculino, rbFemenino;
    private SeekBar skEntradas;
    private TextView tvEntradas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
        txtNombre = (EditText) findViewById(R.id.idTxtNombre);
        txtPassword = (EditText) findViewById(R.id.idTxtPassword);
        txtCorreo = (EditText) findViewById(R.id.idTxtEmail);

        chTeatro = (CheckBox)findViewById(R.id.idChkOpcion1);
        chCine= (CheckBox)findViewById(R.id.idChkOpcion2);
        chCena = (CheckBox)findViewById(R.id.idChkOpcion3);
        rbMasculino = (RadioButton) findViewById(R.id.idRdbMasculino);
        rbFemenino = (RadioButton) findViewById(R.id.idRdbFemenino);

        skEntradas = (SeekBar) findViewById(R.id.idSbControl);
        tvEntradas = (TextView) findViewById(R.id.idTxtEntradas);
        skEntradas.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvEntradas.setText(progress + "  Entradas");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void eventoAnterior(View view){
        Intent Anterior = new Intent(this, MainActivity.class);
        startActivity(Anterior);
    }

    public boolean validarCorreo() {
        String correo = txtCorreo.getText().toString();
        if(correo.isEmpty()){
            txtCorreo.setError("Falta Colocar correo");
            return  false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(correo).matches()){
            txtCorreo.setError("Correo Incorrecto");
            return  false;
        }else{
            txtCorreo.setError(null);
            return false;
        }
    }

    public void eventoEnviar(View view){

        String nombre = txtNombre.getText().toString();
        String clave = txtPassword.getText().toString();
        String correo = txtCorreo.getText().toString();

        String resultado = "";

        if(nombre.length() == 0) {
            resultado = "Falta Nombre ";
        }
        if(clave.length() == 0) {
            resultado = resultado + "Falta Clave ";
        }
        if(!validarCorreo()) {
            resultado = resultado + "Observación en Correo ";
        }

        Toast.makeText(this, resultado, Toast.LENGTH_LONG).show();
    }

    public void eventoEnviarEncuesta(View view){
        String resultado = "";
        if(chTeatro.isChecked()){
            resultado = "Se Selecciono Teatro"+"\n";
        }

        if(chCine.isChecked()){
            resultado =  resultado + "Se Selecciono Cine"+"\n";
        }

        if(chCena.isChecked()){
            resultado = resultado + "Se Selecciono Cena";
        }

        if(rbMasculino.isChecked()){
            resultado = resultado + "Se Selecciono Masculino";
        }else if(rbFemenino.isChecked()){
            resultado = resultado + "Se Selecciono Femenio";
        }
        Toast.makeText(this, resultado, Toast.LENGTH_LONG).show();
    }
}
