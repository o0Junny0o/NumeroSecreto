package com.teste.numerosecreto;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int n;
    int tentativa = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        crianumero();

        TextView qntent = findViewById(R.id.textnumtent);
        qntent.setText(tentativa + "");

    }

    public void crianumero (){
        Random rand = new Random();
        n = rand.nextInt(101);
        TextView textnum = findViewById(R.id.numero);
        textnum.setText(n + "");
    }
    public void dadica(View view) {
        if (n % 2 == 0){
            TextView dicapar = findViewById(R.id.textodica );
            dicapar.setText("É um numero PAR");
        }else{
            TextView dicaimpar = findViewById(R.id.textodica);
            dicaimpar.setText("É um numero IMPAR");
        }
    }


    public void confpalp(View view) {

        //pega o palpite e transforma em int
        EditText pegapalp = findViewById(R.id.palptext);
        String resppalp = pegapalp.getText().toString();
        int numpalp = parseInt (String.valueOf(resppalp));

        if (numpalp == n){
            TextView num = findViewById(R.id.numero);
            num.setVisibility(view.VISIBLE);

            ImageView visponto = findViewById(R.id.ponto);
            visponto.setVisibility(view.INVISIBLE);

            ImageView visup = findViewById(R.id.up);
            visup.setVisibility(view.INVISIBLE);

            ImageView visdown = findViewById(R.id.down);
            visdown.setVisibility(view.INVISIBLE);

        }else if(numpalp != n && numpalp < n){
            tentativa ++;

            ImageView visup = findViewById(R.id.up);
            visup.setVisibility(view.VISIBLE);

            ImageView visdown = findViewById(R.id.down);
            visdown.setVisibility(view.INVISIBLE);
        }else {
            tentativa ++;

            ImageView visdown = findViewById(R.id.down);
            visdown.setVisibility(view.VISIBLE);

            ImageView visup = findViewById(R.id.up);
            visup.setVisibility(view.INVISIBLE);
        }

    }

    public void reiniciajogo(View view) {
        crianumero();
        tentativa = 0;

        TextView num = findViewById(R.id.numero);
        num.setVisibility(view.INVISIBLE);

        ImageView visponto = findViewById(R.id.ponto);
        visponto.setVisibility(view.VISIBLE);

        ImageView visup = findViewById(R.id.up);
        visup.setVisibility(view.INVISIBLE);

        ImageView visdown = findViewById(R.id.down);
        visdown.setVisibility(view.INVISIBLE);

        TextView dicaimpar = findViewById(R.id.textodica);

        TextView dica= findViewById(R.id.textodica);
        dica.setText("");

    }
}