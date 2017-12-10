package com.villegas.formulario;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText date;
    DatePickerDialog datePickerDialog;
    Button siguiente;
    EditText nombre;
    EditText telefono;
    EditText email;
    EditText descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date        = (EditText) findViewById(R.id.etDate);
        nombre      = (EditText) findViewById(R.id.etUsername);
        telefono    = (EditText) findViewById(R.id.etTelephone);
        email       = (EditText) findViewById(R.id.etEmail);
        descripcion = (EditText) findViewById(R.id.etDescription);
        siguiente   = (Button) findViewById(R.id.btnSiguiente);



        if(getIntent().getExtras() != null && !getIntent().getExtras().isEmpty()) {

            nombre.setText(getIntent().getExtras().getString(getResources().getString(R.string.username)));
            date.setText(getIntent().getExtras().getString(getResources().getString(R.string.date)));
            telefono.setText(getIntent().getExtras().getString(getResources().getString(R.string.telephone)));
            email.setText(getIntent().getExtras().getString(getResources().getString(R.string.email)));
            descripcion.setText(getIntent().getExtras().getString(getResources().getString(R.string.descripcion)));

        }


        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, DetalleFormulario.class);
                intent.putExtra(getResources().getString(R.string.username) , nombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.date), date.getText().toString());
                intent.putExtra(getResources().getString(R.string.telephone), telefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.email), email.getText().toString());
                intent.putExtra(getResources().getString(R.string.descripcion), descripcion.getText().toString());
                startActivity(intent);
                finish();
            }
        });

    }
}
