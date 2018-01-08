package com.theredwolfstudio.animadicer.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.theredwolfstudio.animadicer.R;

/**
 * Created by Koldur on 25/12/2017.
 */

public class charge extends Activity {

    TextView log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash);
        log = findViewById(R.id.splashLoadingLog);
        new chargeFile().execute();


    }

    private class chargeFile extends AsyncTask<Void, Integer, Void>{

        //log = findViewById(R.id.splashLoadingLog);

        /*

        try {
            Thread.sleep(3000);
            log.setText("Primer ciclo");
            Thread.sleep(3000);
            log.setText("Segundo ciclo");
            Thread.sleep(3000);
            log.setText("Tercer ciclo");
        }catch(InterruptedException e){
            e.printStackTrace();
        } finally {
            Intent intent = new Intent(charge.this,MainActivity.class);
            startActivity(intent);
        }

        */


        @Override
        protected Void doInBackground(Void... voids) {
            try {
                for (int i = 0; i < 5; i++) {
                    publishProgress(i);
                    Thread.sleep(3000);
                    // Escape early if cancel() is called
                    if (isCancelled()) break;
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Integer... voids) {
            setLog("Ciclo numero " + voids[0] + " completado");
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Intent intent = new Intent(charge.this,MainActivity.class);
            startActivity(intent);
        }
    }

    private void setLog(String val){
        log.setText(val);
    }
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }
    protected void charge() {

        log.setText("Iniciando la carga de personajes");
        SharedPreferences sharedPref = getSharedPreferences("pjs", Context.MODE_PRIVATE);
        log.setText("Cargando número de personajes almacenados");
       int pjs = sharedPref.getInt(getString(R.string.pjsNumber), 0);
       if(pjs==0){
           chargeNewPJ();
       } else {
           chargeFirstPJ();
       }

    }
    private void chargeNewPJ(){
        log.setText("No hay personajes cargados. Inicializando aplicación");
    }

    private void chargeFirstPJ(){
        log.setText("Se han detectado personajes guardados. Cargando...");
    }

}
