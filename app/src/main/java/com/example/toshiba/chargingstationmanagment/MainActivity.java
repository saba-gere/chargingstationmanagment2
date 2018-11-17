package com.example.toshiba.chargingstationmanagment;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.bluetooth.BluetoothDevice;
import android.widget.Button;

import static android.widget.Button.*;



public class MainActivity extends AppCompatActivity {
    private static final String TAG = "myMassage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "on Create");
        Button btn = (Button)findViewById(R.id.button);

        btn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this,station_connect.class));
            }
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.i(TAG, "onStart");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.i(TAG,"onStop");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i(TAG,"onRestart");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG,"onDestroy");
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        Log.i(TAG,"onSaveInstanceState");
    }
    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState){
        super.onRestoreInstanceState(saveInstanceState);
        Log.i(TAG,"onRestoreInstanceState");
    }

}
