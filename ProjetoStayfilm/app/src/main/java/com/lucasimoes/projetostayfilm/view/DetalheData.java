package com.lucasimoes.projetostayfilm.view;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.lucasimoes.projetostayfilm.R;
import com.lucasimoes.projetostayfilm.model.Data;
import com.lucasimoes.projetostayfilm.model.DataDao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

public class DetalheData extends Activity {

    Button salvar;
    TextView data, horainicio, horafim, observacoes;
    ListView listHorarios;

    Spinner motivo;
    Switch diaInteiro;

    LinearLayout LinNovaHora, LinListHora;
    private Data DataAlter;
    private int ano, mes, dia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhedata);

        data = (TextView)findViewById(R.id.edData);
        horainicio = (TextView) findViewById(R.id.txtHoraInicio);
        horafim = (TextView)findViewById(R.id.txtHoraFim);
        observacoes = (TextView)findViewById(R.id.edObservacoes);

        motivo = (Spinner)findViewById(R.id.spMotivo);
        diaInteiro = (Switch)findViewById(R.id.swDiaInteiro);

        listHorarios = (ListView) findViewById(R.id.ListHorarios);

        LinListHora = (LinearLayout)findViewById(R.id.LinLayListDatas);
        LinNovaHora = (LinearLayout)findViewById(R.id.LinLayNovaData);

        salvar = (Button)findViewById(R.id.btSalvar);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String funcao = extras.getString("funcao");

        if (funcao.equals("alterar")){
            LinListHora.setVisibility(View.VISIBLE);
            LinNovaHora.setVisibility(View.INVISIBLE);
            if (extras != null){
                //alteração
                long id = extras.getLong("id");
                DataAlter = DataDao.instancia.localizar(id);

                if (DataAlter != null){
                    data.setText(DataAlter.getData());
                   // horaum.setText(DataAlter.getHorarios());
                    data.setEnabled(false);
                    //TODO: carregar os itens do TODO
                }
            }
        } if (funcao.equals("novo")){
            LinListHora.setVisibility(View.INVISIBLE);
            LinNovaHora.setVisibility(View.VISIBLE);

        }

        Calendar calendar = Calendar.getInstance();
        ano = calendar.get(Calendar.YEAR);
        mes = calendar.get(Calendar.MONTH);
        dia = calendar.get(Calendar.DAY_OF_MONTH);
        data.setText(dia + " / " + (mes + 1) + " / " + ano);


    }

    //ação para selecionar a data pelo DatePicker, ao clickar aparecerá a opção escolhida
    public void selecionarData(View view) {
        showDialog(view.getId());
    }
    @Override
    protected Dialog onCreateDialog(int id) {
        if (R.id.edData == id) {
            return new DatePickerDialog(this, listener, ano, mes, dia);
        }
        return null;
    }
    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            ano = year;
            mes = monthOfYear;
            dia = dayOfMonth;
            data.setText(dia + " / " + (mes + 1) + " / " + ano);
        }
    };

    public void SwitchChange (View view){
        if (diaInteiro.isChecked()){
            Toast.makeText(this, "Ligado", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "Desligado", Toast.LENGTH_SHORT).show();
        }
    }


}
