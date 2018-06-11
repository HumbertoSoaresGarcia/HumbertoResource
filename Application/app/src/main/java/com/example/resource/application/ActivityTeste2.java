package com.example.resource.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityTeste2 extends AppCompatActivity {

    private EditText editText;
    public static String campo1;
    public Button buttonVoltar;
    private Button buttonAvanc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste2);

        final Intent intent = getIntent();
        String texto = intent.getStringExtra(MainActivity.message_name);

        editText = (EditText) findViewById(R.id.editText);
        editText.setText(texto);

        buttonVoltar = (Button) findViewById(R.id.buttonVoltar);
        buttonAvanc = (Button) findViewById(R.id.buttonAvanc);

        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent returnIntent = new Intent(ActivityTeste2.this, MainActivity.class);

                String campoTexto1 = editText.getText().toString();
                returnIntent.putExtra(campo1, campoTexto1);

                setResult(1,returnIntent);
                finish();

            }
        });

        buttonAvanc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intentAvanc = new Intent(ActivityTeste2.this, ActivityTeste3.class );
                startActivity(intentAvanc);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent returnIntent = new Intent();

        String campoTexto1 = editText.getText().toString();
        returnIntent.putExtra(campo1, campoTexto1);

        setResult(1,returnIntent);
        finish();

    }

}
