package com.projetos.appbov;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ListaRacas extends AppCompatActivity {
    ListView lista;
    String raças;
    Cursor cursor;
    String codigo;
    AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_racas);

        String[] campos = new String[] {"_Raças", "Qts"};
        int[] idViews = new int[]{R.id.twRaca, R.id.twQts};

        SimpleCursorAdapter ad = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_cadastro_boi, cursor, campos, idViews, 0);

        lista = (ListView) findViewById(R.id.listRaca);
        lista.setAdapter(ad);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                cursor.moveToPosition(i);
                codigo = cursor.getString(cursor.getColumnIndexOrThrow("_Raças"));
                AlertDialog.Builder builder = new AlertDialog.Builder(ListaRacas.this);
                builder.setTitle("");
                builder.setMessage("O que deseja fazer ?");
                builder.setPositiveButton("Alterar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(ListaRacas.this,CadastroBoi.class);
                        intent.putExtra("codigo",codigo);
                        intent.putExtra("acao","alterar");
                        startActivity(intent);
                        finish();//fecha a tela atual, no caso ListActivity

                    }
                });

                builder.setNegativeButton("Excluir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alerta = builder.create();
                alerta.show();
            }
        });
    }
}
