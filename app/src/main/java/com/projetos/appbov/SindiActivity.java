package com.projetos.appbov;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SindiActivity extends AppCompatActivity {

    Spinner spinner;
    TextView titulo, descricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sindi);

        spinner = findViewById(R.id.spinner_Sindi);
        titulo = findViewById(R.id.tituloDescSindi);
        descricao = findViewById(R.id.descSindi);

        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(this,R.array.spinner_opcoes, R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (spinner.getSelectedItemPosition()){
                    case 0:
                        titulo.setText("Características Gerais");
                        descricao.setText("Os animais da raça Sindi são em geral pequenos, de bela aparência, adequados para " +
                                "regiões de poucos recursos alimentares, onde seria difícil a manutenção de animais de grande porte. " +
                                "O gado Sindi é uma raça chave para viabilizar a criação de bovinos nas regiões que têm sofrido com as mudanças " +
                                "climáticas dos últimos tempos, e que vem se repetindo com mais frequência. Os países tropicais apresentam uma " +
                                "significativa demanda de animais mais rústicos, adaptados à seca, resistentes e produtivos.");
                        break;
                    case 1:
                        titulo.setText("Características Ambientais");
                        descricao.setText("-Adaptam-se facilmente a diferentes condições de clima e solo. São compactos, tendo os quartos traseiros " +
                                "arredondados e caídos.\n" +
                                "-Se adaptam bem em pastagens de baixa qualidade, a raça apresenta certo grau de resistência à febre aftosa, tolera " +
                                "temperaturas elevadas através da regulação metabólica, produz carne de boa qualidade.\n");
                        break;
                    case 2:
                        titulo.setText("Instalações");
                        descricao.setText("-Mediante condições de baixa disponibilidade de pastos e outros volumosos, falta de água e " +
                                "baixa disponibilidade de capital, os bovinos da raça Sindi ainda conseguem fornecer benefício financeiro.");
                        break;
                    case 3:
                        titulo.setText("Peso");
                        descricao.setText("-Na avaliação de carcaças de um lote de 30 machos não castrados abatidos com média de 526 quilos, a raça apresentou " +
                                "resultados surpreendentes. Com ótima musculosidade e boa relação carne/osso, o rendimento médio de carne aproveitável total foi de " +
                                "75%.");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
