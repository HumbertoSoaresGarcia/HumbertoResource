package com.example.resource.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ActivityTeste3 extends AppCompatActivity {

    private ListView listView;
    private Button buttonVoltar;
    private String[] lista = {"Teste 1","Teste 2","Teste 3","Teste 4","Teste 4","Teste 5",
            "Teste 6","Teste 7","Teste 8","Teste 9","Teste 10","Teste 11","Teste 12","Teste 13",
            "Teste 14","Teste 15","Teste 16","Teste 17","Teste 18","Teste 18","Teste 19","Teste 20",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste3);

        listView = (ListView) findViewById(R.id.listViewId);
        buttonVoltar = (Button) findViewById(R.id.buttonVoltar);

        ArrayAdapter<String> listaAdapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                lista );
        listView.setAdapter(listaAdapter);

        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intentVoltar = new Intent(ActivityTeste3.this, ActivityTeste2.class);
//                startActivity(intentVoltar);
                finish();
            }
        });
    }

}
