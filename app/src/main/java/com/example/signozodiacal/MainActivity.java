package com.example.signozodiacal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public static String syear;

    Button buttonCalcularSigno;



    EditText editTextNombre, editTextNumerodeCuenta, editTextEmail, editTextFechadeNacimiento;
    DatePickerDialog.OnDateSetListener setListener;
    //int ultimoAnio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNombre = (EditText)findViewById(R.id.editTextNombre);
        editTextEmail = (EditText)findViewById(R.id.editTextEmail);
        editTextNumerodeCuenta = (EditText)findViewById(R.id.editTextNumerodeCuenta);
        editTextFechadeNacimiento = (EditText)findViewById(R.id.editTextFechadeNacimiento);




       // editTextFechadeNacimiento = findViewById(R.id.editTextFechadeNacimiento);
        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        //final int ultimo = calendar.get(Calendar.YEAR);
        //syear = year;



        editTextFechadeNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_Holo_Dialog_NoActionBar_MinWidth
                ,setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                datePickerDialog.show();
            }
        });



        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {


                month = month + 1;
                year = year;
                Toast.makeText(MainActivity.this, "hola"+year, Toast.LENGTH_LONG).show();
                String date = dayOfMonth + "/" + month + "/" + year;
                String ultimoanio = String.valueOf(year);
                syear = ultimoanio;
                editTextFechadeNacimiento.setText(date);



            }
        };





        buttonCalcularSigno = findViewById(R.id.buttonCalcularSigno);
        buttonCalcularSigno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, infoSigno.class);

                editTextNombre.setError(null);
                editTextNumerodeCuenta.setError(null);
                editTextEmail.setError(null);
                editTextFechadeNacimiento.setError(null);


                String nombre = editTextNombre.getText().toString().trim();
                String numerodeCuenta = editTextNumerodeCuenta.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String fecha = editTextFechadeNacimiento.getText().toString().trim();

                int count = 0;

                if(nombre.isEmpty()){
                    editTextNombre.setError("Debes ingresar un nombre");
                    //Toast.makeText(this, "Debes ingresar un nombre", Toast.LENGTH_LONG).show();

                }

                if(numerodeCuenta.isEmpty()){
                    //Toast.makeText(this, "Debes ingresar un número de cuenta", Toast.LENGTH_LONG).show();
                    editTextNumerodeCuenta.setError("Debes ingresar un número de cuenta");

                }else if(numerodeCuenta.length() > 1 && numerodeCuenta.length() < 9 ){
                    editTextNumerodeCuenta.setError("Tú número de cuenta debe tener 9 caracteres");
                }else{
                    count += 1;
                }

                if(email.isEmpty()){
                    //Toast.makeText(this, "Debes ingresar un correo electrónico", Toast.LENGTH_LONG).show();
                    editTextEmail.setError("Debes ingresar un correo electrónico");

                }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    editTextEmail.setError("Ingresa un correo electrónico valido");

                }else {
                    count += 1;
                }

                if(fecha.isEmpty()){
                    //Toast.makeText(this, "Debes seleccionar una fecha de nacimiento", Toast.LENGTH_LONG).show();

                    editTextFechadeNacimiento.setError("Debes seleccionar una fecha de nacimiento");

                }else{

                    editTextFechadeNacimiento.setError(null);

                }

                    if(count==2){
                        startActivity(intent);
                    }

                }
            });
    }



    public String ultimoyear(){

        return this.syear;

    }



}

