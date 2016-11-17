package com.lucasimoes.projetostayfilm.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.lucasimoes.projetostayfilm.R;
import com.lucasimoes.projetostayfilm.model.Data;
import com.lucasimoes.projetostayfilm.model.Item;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import static android.R.attr.data;


public class DashBoardActivity extends AppCompatActivity {

    private ListView listDatas;
    private DataAdapter adapter;
   // private Data data = new Data();
    String funcao;

    public static final int EDITAR_ITEM = 0;
    public static final int INCLUIR_ITEM = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        listDatas = (ListView) findViewById(R.id.lstDatas);
        adapter = new DataAdapter(this, Data.LISTA);
        listDatas.setAdapter(adapter);

        listDatas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                funcao = "alterar";
                Intent intent = new Intent(getBaseContext(), DetalheData.class);
                intent.putExtra("id", id);
                intent.putExtra("funcao", funcao );
                startActivityForResult(intent, EDITAR_ITEM); //chama a intent aguardando uma resposta

            }
        });
                //implementação do ButtonFloating
        FloatingActionButton btAdd = (FloatingActionButton) findViewById(R.id.btnfloating);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcao = "novo";
                //Todo: Implementar botão adicionar
                Intent intent = new Intent(getBaseContext(), DetalheData.class);
                intent.putExtra("funcao", funcao);
                startActivityForResult(intent, INCLUIR_ITEM); //chama a intent aguardando uma resposta


            }
        });
    }
    @Override   //verifica o resultado da intent e toma uma decisão (Notify atualiza a lista quando um item é alterado
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            adapter.notifyDataSetChanged();

        }
    }

    @Override //inicio MENU
    public boolean onCreateOptionsMenu(Menu menu){
    getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        String opcao;
        int id = item.getItemId();
            switch (id){
                case R.id.menu_monitoria:
                    opcao = "monitoria";
                    Intent it = new Intent(this, ActivityCuradoria.class);
                    it.putExtra("status", opcao);
                    startActivity(it);
                    break;
                case R.id.menu_curadoria:
                    opcao = "curadoria";
                    Intent i = new Intent(this, ActivityCuradoria.class);
                    i.putExtra("status", opcao);
                    startActivity(i);
                    break;
                case R.id.menu_sair:
                    Bsair();
                    break;
            }

        return super.onOptionsItemSelected(item);
    }

    private void Bsair(){

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch(which){
                    case DialogInterface.BUTTON_POSITIVE:
                        Intent it = new Intent(DashBoardActivity.this, MainActivity.class);
                        startActivity(it);
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        Intent ite = new Intent(DashBoardActivity.this, DashBoardActivity.class);
                        startActivity(ite);
                        break;

                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Tem certeza que deseja Sair?").setPositiveButton("Sim", dialogClickListener).setNegativeButton("Não", dialogClickListener).show();

    }
}
