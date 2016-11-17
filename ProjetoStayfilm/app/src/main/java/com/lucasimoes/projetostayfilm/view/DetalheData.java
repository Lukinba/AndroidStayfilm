package com.lucasimoes.projetostayfilm.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.lucasimoes.projetostayfilm.R;
import com.lucasimoes.projetostayfilm.model.Data;
import com.lucasimoes.projetostayfilm.model.DataDao;
import com.lucasimoes.projetostayfilm.model.Item;
import com.lucasimoes.projetostayfilm.model.ItemDao;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DetalheData extends Activity implements View.OnClickListener {

    Button salvar;
    TextView dataTitulo, horainicio, horafim;
    ListView listHorarios;

    Switch diaInteiro;

    LinearLayout LinNovaHora, LinListHora;
    private Data DataAlter;
    private ItemDao itemDao;
    private BaseAdapter detalhe;
    String date;
    private int ano, mes, dia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhedata);

        dataTitulo = (TextView)findViewById(R.id.edData);
        horainicio = (TextView) findViewById(R.id.txtHoraInicio);
        horafim = (TextView)findViewById(R.id.txtHoraFim);

        diaInteiro = (Switch)findViewById(R.id.swDiaInteiro);

        LinListHora = (LinearLayout)findViewById(R.id.LinLayListDatas);
        LinNovaHora = (LinearLayout)findViewById(R.id.LinLayNovaData);

        salvar = (Button)findViewById(R.id.btSalvar);
        salvar.setOnClickListener(this);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String funcao = extras.getString("funcao");


            if (extras != null && funcao.equals("alterar")) { //alteração
                LinListHora.setVisibility(View.VISIBLE);
                LinNovaHora.setVisibility(View.INVISIBLE);

                long id = extras.getLong("id");
                DataAlter = DataDao.instancia.localizar(id);

                if (DataAlter != null) {
                    dataTitulo.setText(DataAlter.getData());
                    dataTitulo.setEnabled(false);
                    salvar.setText("Voltar");
                    itemDao = ItemDao.getInstace(DataAlter.getItens());
                    detalhe = new HorarioAdapter(this, itemDao);

            }
            }else {
                if (funcao.equals("novo")) {
                    LinListHora.setVisibility(View.INVISIBLE);
                    LinNovaHora.setVisibility(View.VISIBLE);

                    date = DateFormat.getDateInstance().format(new Date());
                    dataTitulo.setText(date);
                    itemDao = ItemDao.getInstace(new ArrayList<Item>());
                    detalhe = new HorarioAdapter(this, itemDao);
                }
            }

                //criando a segunda lista para apresentar Horarios
            listHorarios = (ListView)findViewById(R.id.ListHorarios);
            listHorarios.setAdapter(detalhe);

//            // montando calendário
//        Calendar calendar = Calendar.getInstance();
//        ano = calendar.get(Calendar.YEAR);
//        mes = calendar.get(Calendar.MONTH);
//        dia = calendar.get(Calendar.DAY_OF_MONTH);
//        dataTitulo.setText(dia + " / " + (mes + 1) + " / " + ano);

    }
//
//    //ação para selecionar a data pelo DatePicker, ao clickar aparecerá a opção escolhida
//   private void selecionarData() {
//
//        showDialog(this);
//    }
//    @Override
//    protected Dialog onCreateDialog(int id) {
//        if (R.id.edData == id) {
//            return new DatePickerDialog(this, listener, ano, mes, dia);
//        }
//        return null;
//    }
//    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
//        @Override
//        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//            ano = year;
//            mes = monthOfYear;
//            dia = dayOfMonth;
//            dataTitulo.setText(dia + " / " + (mes + 1) + " / " + ano);
//        }
//    };
            //Ação para o alterar opcao do dia completo
    public void SwitchChange (View view){
        if (diaInteiro.isChecked()){
            Toast.makeText(this, "Ligado", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "Desligado", Toast.LENGTH_SHORT).show();
        }
    }

    @Override //Ação do Button Salvar
    public void onClick(View v) {
        if (DataAlter == null){
            //nova Data
            Data data = new Data();
            data.setData(dataTitulo.getText().toString());
            data.setItens(itemDao.listar());

            DataDao.instancia.salvar(data);
        }
        setResult(RESULT_OK);
        finish();
    }
}
