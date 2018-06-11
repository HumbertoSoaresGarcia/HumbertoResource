package com.example.resource.application;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private TextView textView1;
    private TextView textView2;
    private EditText editText1;
    private EditText editText2;
    private String txtV1;
    private String txtV2;
    private boolean textViewShow1 = true;
    private boolean textViewShow2 = true;
    private ImageView imageView;
    public static String message_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(getApplicationContext(),"onCreate() chamado.",Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.btn1);
        button2 = (Button) findViewById(R.id.btn2);
        button3 = (Button) findViewById(R.id.btn3);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        imageView = (ImageView) findViewById(R.id.imageView);

        AssetManager assetManager = getAssets();
        //imageView.setImageDrawable(getDrawable(R.drawable.ic_launcher_background));

        try {
            InputStream ims = assetManager.open("android.png");
            Drawable d = Drawable.createFromStream(ims, null);
            imageView.setImageDrawable(d);
        } catch (IOException ex) {
            return;
        }

        button1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            textView1 = (TextView) findViewById(R.id.txt1);

        if(textViewShow1 == true){
            txtV1 = editText1.getText().toString();
            textView1.setText(txtV1);
            textViewShow1 = false;
        }else{
            txtV1 = editText1.getText().toString();
            textView1.setText("View 1");
            textViewShow1 = true;
        }
    }
});

        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                textView2 = (TextView) findViewById(R.id.txt2);

                if(textViewShow2 == true){
                    txtV2 = editText2.getText().toString();
                    textView2.setText(txtV2);
                    textViewShow2 = false;
               }else{
                    txtV2 = editText2.getText().toString();
                    textView2.setText("View 2");
                    textViewShow2 = true;
                }
            }
    });

button3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        AssetManager assetManager = getAssets();

        try {
            InputStream ims = assetManager.open("logo.png");
            Drawable d = Drawable.createFromStream(ims, null);
            imageView.setImageDrawable(d);
        } catch (IOException ex) {
            return;
        }

        Intent intent = new Intent(MainActivity.this, ActivityTeste2.class);
        editText1 = (EditText) findViewById(R.id.editText1);
        String messageName = editText1.getText().toString();
        intent.putExtra(message_name, messageName);

        startActivityForResult(intent,1);

    }
});

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            if(requestCode == 1) {
                String result_campo1 = data.getStringExtra(ActivityTeste2.campo1);
                editText2.setText(result_campo1);
              }
    }

    // CICLO ACTIVITY //

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),"onStart() chamado. ",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(),"onRestart() chamado.", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"onResume() chamado.", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),"onStop() chamado.", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"onDestroy() chamado.",Toast.LENGTH_SHORT).show();
    }
}
