package com.example.biscoitodasorte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String[] frases = {
        "Água mole em pedra dura tanto bate até que fura.",
        "a vida trará coisas boas se tiver paciência.",
        "Não compense na ira o que lhe falta na razão.",
        "A maior de todas as torres começa no solo.",
        "Siga os bons e aprenda com eles.",
    };
    int cont = 0;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(this, R.raw.sombiscoito);
    }
    public void clicou(View view){
        TextView t = findViewById(R.id.texto);
        t.setText("Tenha um bom dia!");
        Random r = new Random();
        int i = r.nextInt(frases.length);
        t.setText(frases[i]);
        TextView contador = findViewById(R.id.contador);
        contador.setText(String.valueOf(++cont));
        mp.start();
        Drawable quebrado = getDrawable(R.drawable.biscoitoquebrado);
        ImageButton botao = findViewById(R.id.imageButton);
        botao.setImageDrawable(quebrado);
    }
    public void compartilhar(View view){
        Intent enviar = new Intent();
        enviar.setAction(Intent.ACTION_SEND);
        TextView t = findViewById(R.id.texto);
        enviar.putExtra(Intent.EXTRA_TEXT, t.getText().toString());
        enviar.setType("text/plain");
        startActivity(Intent.createChooser(enviar,"Enviar para:"));
    }
}