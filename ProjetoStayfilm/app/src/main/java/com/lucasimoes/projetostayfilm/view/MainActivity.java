package com.lucasimoes.projetostayfilm.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lucasimoes.projetostayfilm.R;

public class MainActivity extends AppCompatActivity {

    TextView login, senha;
    Button entrar, enviar;
    TextView recuperar, email;

    private LinearLayout Login, Recuperar;
    private RelativeLayout RelLogin, RelRecuperar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (TextView)findViewById(R.id.edNome);
        senha = (TextView)findViewById(R.id.edSenha);

        recuperar = (TextView)findViewById(R.id.txtRecupSenha);
        email = (TextView)findViewById(R.id.edEmail);

        Login = (LinearLayout) findViewById(R.id.LinLayLogin);
        Recuperar = (LinearLayout) findViewById(R.id.LinLayRecuperar);
        RelLogin = (RelativeLayout)findViewById(R.id.RelLayLogin);
        RelRecuperar = (RelativeLayout)findViewById(R.id.RelLayRecup);

        enviar = (Button)findViewById(R.id.btEnviar);
        entrar = (Button)findViewById(R.id.btEntrar);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, DashBoardActivity.class);
                   startActivity(i);

            }
        });
                //para alterar o Layout
        recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Login.setVisibility(View.INVISIBLE);
                RelLogin.setVisibility(View.INVISIBLE);

                Recuperar.setVisibility(View.VISIBLE);
                RelRecuperar.setVisibility(View.VISIBLE);

            }
        });

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getText().toString();
                if (mail.equals("")) {
                    Toast.makeText(getApplicationContext(), "Digite um email válido!", Toast.LENGTH_SHORT).show();

                } else{
                    Toast.makeText(getApplicationContext(), "Email enviado com Sucesso! " + " Faça o Login novamente", Toast.LENGTH_SHORT).show();
                    Login.setVisibility(View.VISIBLE);
                    RelLogin.setVisibility(View.VISIBLE);

                    Recuperar.setVisibility(View.INVISIBLE);
                    RelRecuperar.setVisibility(View.INVISIBLE);

                }
            }
        });



    }
}
