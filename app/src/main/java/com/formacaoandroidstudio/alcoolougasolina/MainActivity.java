package com.formacaoandroidstudio.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

/**
 * Anotações:
 *
 *  Vamos centralizar o constraintLayout - lembrando que todos os componentes que estão dentro do constrainLayout
 *  também serão centralizados. Para fazer essa centralização primeiro vamos trocar de 'match_parent' para 'wrap_content'
 *  no attributes 'layout_height', que vai deixar na altura do seu conteúdo. Depois vamos no attributes 'layout_gravity'
 *  e escolher a opção 'center_vertical' para centralizar todo o nosso conteúdo no layout do app.
 * */