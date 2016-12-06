package com.lucasimoes.escalastayfilm.model;

import android.widget.Toast;

import com.lucasimoes.escalastayfilm.DataList;
import com.lucasimoes.escalastayfilm.lib.JSONParser;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.StringReader;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DatasDao {
        public static DatasDao instanceD = new DatasDao();
        private final String url = "http://localhost/Prj_StayFilm/listarEscalaMontada/1?";

        public List<Datas> mListDatas;

        private DatasDao(){}

    public List<Datas> listar(boolean bloqueado) {
        mListDatas = new ArrayList<>();

        Date mDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(mDate);
        Format mFormatMes = new SimpleDateFormat("MM");
        Format mFormatAno = new SimpleDateFormat("yyyy");

        try {
            String json = new JSONParser.Consultar(url + "mes="+mFormatMes.format(c.getTime())+"&ano="+mFormatAno.format(c.getTime()) , new JSONParser.DataCallBack() {
                @Override
                public void setResponse(int code, String json) {
                    if(code != 200)
                        Toast.makeText(DataList.mcontext, "Falha ao consultar os Dados", Toast.LENGTH_LONG).show();
                }
            }).execute().get();
            ObjectMapper mapper = new ObjectMapper();
            mListDatas = Arrays.asList(mapper.readValue(new StringReader(json), Datas[].class));
        } catch (Exception ex) {
            Toast.makeText(DataList.mcontext, "Falha no acesso ao Servidor", Toast.LENGTH_LONG).show();
        }
        return mListDatas;
    }
    
}

