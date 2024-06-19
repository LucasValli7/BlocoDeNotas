package br.com.desenvolvedor.blocodenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private AnotacaoP preferencias;
    private EditText editAnotacao;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        FloatingActionButton fbSalvar = findViewById(R.id.fb_salvar);
        editAnotacao = findViewById(R.id.editAnotação);

        preferencias = new AnotacaoP(getApplicationContext());

        fbSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textoRecuperado = editAnotacao.getText().toString();

                if (textoRecuperado.equals("")){

                    Toast.makeText(getApplicationContext(),"Preencha a Anotação",Toast.LENGTH_SHORT).show();
                }else {
                    preferencias.salvarAnotacao(textoRecuperado);
                    Toast.makeText(getApplicationContext(),"Anotação Salva com Sucesso",Toast.LENGTH_SHORT).show();

                }
            }
        });

        String anotacao = preferencias.recuperarAnotacao();
        if (!anotacao.equals("")){
            editAnotacao.setText(anotacao);

        }

    }
}