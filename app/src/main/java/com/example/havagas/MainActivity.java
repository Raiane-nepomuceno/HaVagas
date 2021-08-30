package com.example.havagas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private EditText nomeEt;
    private EditText emailEt;
    private EditText anoformaturaEt;
    private LinearLayout dadosLl;
    private Spinner formacaoSp;
    private RadioGroup sexoRg;
    private RadioButton masculinoRb;

    private ArrayList<String> estadoAcademicolList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();

       estadoAcademicolList = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.formacao_academica)));
        ArrayAdapter<String> estadoAcademicoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, estadoAcademicolList);
        formacaoSp.setAdapter( estadoAcademicoAdapter);

    }
    public void onItemSelected(AdapterView<?> adapterView, View view, int posicao, long id) {
        if (estadoAcademicolList.get(posicao).equals("Fundamental") || estadoAcademicolList.get(posicao).equals("Médio")) {
            dadosLl.setVisibility(View.VISIBLE);
        }
        else {
            dadosLl.setVisibility(View.GONE);
            anoformaturaEt.setText("");
        }
    }

    public void onClick(View view){
        if (view.getId() == R.id.salvarBt) {
            Toast.makeText(this, "Botão salvar foi clicado", Toast.LENGTH_SHORT).show();
        }
        else {
            if (view.getId() == R.id.limparBt) {
                Toast.makeText(this, "Botão limpar foi clicado", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void bindViews() {
        nomeEt = findViewById(R.id.nomeEt);
        emailEt = findViewById(R.id.emailEt);
        sexoRg = findViewById(R.id.sexoRg);
        dadosLl = findViewById(R.id.dadosLl);
        formacaoSp = findViewById(R.id.formacaoSp);
        masculinoRb = findViewById(R.id.masculinoRb);
        anoformaturaEt = findViewById(R.id.anoformaturaEt);
    }
}