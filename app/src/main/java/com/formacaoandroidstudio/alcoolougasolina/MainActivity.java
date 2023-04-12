package com.formacaoandroidstudio.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    /* Declarando os componentes */
    private TextInputEditText precoAlcool, precoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Capturando os ids dos componentes */
        precoAlcool = findViewById(R.id.editPrecoAlcool);
        precoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado = findViewById(R.id.textResultado);
    }

    public void calcularPreco(View view){
        /* Recuperar os valores digitados */
        String alcool = precoAlcool.getText().toString();
        String gasolina = precoGasolina.getText().toString();

        /* Regra de negócio verificar se o usuário digitou no campo texto */
        Boolean camposValidados = validarCampos(gasolina, alcool);

        /* Recebe true  - caixa de textos foram preenchidos */
        if(camposValidados){

            /* Convertendo String para número (int) - Vale ressaltar que tudo que vem da tela vem com tipo String */
            Double valorAlcool = Double.parseDouble(alcool);
            Double valorGasolina = Double.parseDouble(gasolina);

            /**
             * Fazer cálculo em menor preço
             * Se (valorAlcool / valorGasolina) >= 0.7 é melhor utilizar gasolina
             * senão é melhor utilizar alcool. */
            if((valorAlcool/valorGasolina) >= 0.7){
                textResultado.setText("É melhor utilizar gasolina");
            }else{
                textResultado.setText("É melhor utilizar álcool");
            }

        }else{ /* recebe false - caixa de textos NÃO foram preenchidas */
            textResultado.setText("Preencha os preços primeiro");
        }
    }


    /* Método para validar os campos de textos */
    public Boolean validarCampos(String pGasolina, String pAlcool){
        Boolean camposValidados = true;

        if(pGasolina == null || pGasolina.equals("")){
            camposValidados = false;

        }else if(pAlcool == null || pAlcool.equals("")){
            camposValidados = false;
        }

        return camposValidados;
    }
}

/**
 * Anotações:
 *
 *  Vamos centralizar o constraintLayout - lembrando que todos os componentes que estão dentro do constrainLayout
 *  também serão centralizados. Para fazer essa centralização primeiro vamos trocar de 'match_parent' para 'wrap_content'
 *  no attributes 'layout_height', que vai deixar na altura do seu conteúdo. Depois vamos no attributes 'layout_gravity'
 *  e escolher a opção 'center_vertical' para centralizar todo o nosso conteúdo no layout do app.
 *
 *  Vale Ressaltar:
 *  Como vamos trabalhar com números nos campos de texto, então vamos apenas usar teclado com números. Logo para definir
 *  um teclado com números, vamos no 'TextInputEditText' e em 'attributes' na propriedade 'inputType' vamos definir o valor
 *  'numberDecimal'.
 *
 *  Para conversões de tipos Integer, Double, Float usa-se o Parser.
 *  Para conversão de tipo String usa-se o ValueOf.
 * */