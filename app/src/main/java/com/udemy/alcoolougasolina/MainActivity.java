package com.udemy.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    Button   botao;
    EditText edit_gasolina;
    EditText edit_alcool;
    TextView recomendacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao = findViewById(R.id.button);
        edit_gasolina = findViewById(R.id.id_edit_preco_gasolina);
        edit_alcool = findViewById(R.id.id_edit_preco_alcool);
        recomendacao = findViewById(R.id.id_text_recomendacao);
    }

    public void calcular_menor_preco( View view ) {

        String preco_gasolina = edit_gasolina.getText().toString();
        String preco_alcool   = edit_alcool.getText().toString();
        String menssagem      = "Um dos compos estão vazio.";

         if ( validar_campo( preco_gasolina, preco_alcool ) )
             Toast.makeText( this,menssagem, Toast.LENGTH_LONG ).show();
         else {
             double p_gasolina =  Double.parseDouble( preco_gasolina );
             double p_alcool   =  Double.parseDouble( preco_alcool );

             if ( p_gasolina < p_alcool) {
                 recomendacao.setText("Recomenda-se Gasolina");
             } else {
                 recomendacao.setText("Recomenda-se Alcool");
             }
         }
    }

    boolean validar_campo( String edit_gasolina, String edit_alcool )
    {
            boolean retorno = false;

            if ( edit_alcool.equals("") || edit_alcool.equals("") )
            {
                retorno = true;
            }
            return  retorno;
    }
}