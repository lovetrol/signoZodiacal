package com.example.signozodiacal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Year;
import java.time.chrono.ChronoPeriod;
import java.util.Calendar;

import static com.example.signozodiacal.R.id.imageViewHoroscopo;
import static com.example.signozodiacal.R.id.textViewEdad;

public class infoSigno extends AppCompatActivity {

    private TextView textViewEdad, textViewHoroscopo;
    private ImageView imageViewHoroscopo;
    Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);

    static MainActivity yearF = new MainActivity();

    String yearSF = yearF.ultimoyear();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_signo);


        calculandoEdad();
        calculandoSignoZodiacal();

    }

    public void calculandoSignoZodiacal(){

        textViewHoroscopo = findViewById(R.id.textViewHoroscopo);
        imageViewHoroscopo = findViewById(R.id.imageViewHoroscopo);

        //textViewEdad.setText(year);

        switch (Integer.parseInt(yearSF) % 12) {
            case 0:
                textViewHoroscopo.setText("Mono");
                imageViewHoroscopo.setImageResource(R.drawable.mono);
                System.out.println("monkey");
                break;
            case 1:
                textViewHoroscopo.setText("Gallo");
                imageViewHoroscopo.setImageResource(R.drawable.gallo);
                System.out.println("rooster");
                break;
            case 2:
                textViewHoroscopo.setText("Perro");
                imageViewHoroscopo.setImageResource(R.drawable.perro);
                System.out.println("dog");
                break;
            case 3:
                textViewHoroscopo.setText("Cerdo");
                imageViewHoroscopo.setImageResource(R.drawable.cerdo);
                System.out.println("pig");
                break;
            case 4:
                textViewHoroscopo.setText("Rata");
                imageViewHoroscopo.setImageResource(R.drawable.rata);
                System.out.println("rat");
                break;
            case 5:
                textViewHoroscopo.setText("Buey");
                imageViewHoroscopo.setImageResource(R.drawable.buey);
                System.out.println("ox");
                break;
            case 6:
                textViewHoroscopo.setText("Tigre");
                imageViewHoroscopo.setImageResource(R.drawable.tigre);
                System.out.println("tiger");
                break;
            case 7:
                textViewHoroscopo.setText("Conejo");
                imageViewHoroscopo.setImageResource(R.drawable.conejo);
                System.out.println("rabbit");
                break;
            case 8:
                textViewHoroscopo.setText("Dragon");
                imageViewHoroscopo.setImageResource(R.drawable.dragon);
                System.out.println("dragon");
                break;
            case 9:
                textViewHoroscopo.setText("Serpiente");
                imageViewHoroscopo.setImageResource(R.drawable.serpiente);
                System.out.println("snake");
                break;
            case 10:
                textViewHoroscopo.setText("Caballo");
                imageViewHoroscopo.setImageResource(R.drawable.caballo);
                System.out.println("horse");
                break;
            case 11:
                textViewHoroscopo.setText("Oveja");
                imageViewHoroscopo.setImageResource(R.drawable.oveja);
                System.out.println("sheep");
                break;
        }

    }
    public void calculandoEdad(){

        textViewEdad = findViewById(R.id.textViewEdad);

        int years = year - Integer.parseInt(yearSF);
        Toast.makeText(infoSigno.this, "hola"+yearSF, Toast.LENGTH_LONG).show();
        String edad = String.valueOf(years);
        textViewEdad.setText(edad);

        }


    }



