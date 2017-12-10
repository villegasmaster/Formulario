package com.villegas.formulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class DetalleFormulario extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDate;
    private TextView tvDesc;
    private Button btnEditar;

    String nombre;
    String fecha;
    String telefono;
    String email;
    String descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_formulario);
        Bundle params = getIntent().getExtras();

        nombre       = params.getString(getResources().getString(R.string.username));
        fecha        = params.getString(getResources().getString(R.string.date));
        telefono     = params.getString(getResources().getString(R.string.telephone));
        email        = params.getString(getResources().getString(R.string.email));
        descripcion  = params.getString(getResources().getString(R.string.descripcion));


        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvDate = (TextView) findViewById(R.id.etDate);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDesc = (TextView) findViewById(R.id.tvDesc);
        btnEditar = (Button) findViewById(R.id.btnEditar);

        tvNombre.setText(nombre);
        tvDate.setText(fecha);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDesc.setText(descripcion);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetalleFormulario.this, MainActivity.class);
                intent.putExtra(getResources().getString(R.string.username) ,nombre);
                intent.putExtra(getResources().getString(R.string.date), fecha);
                intent.putExtra(getResources().getString(R.string.telephone), telefono);
                intent.putExtra(getResources().getString(R.string.email), email);
                intent.putExtra(getResources().getString(R.string.descripcion), descripcion);
                startActivity(intent);
                finish();
            }
        });

    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(DetalleFormulario.this, MainActivity.class);
        }

        return super.onKeyDown(keyCode, event);
    }
}
