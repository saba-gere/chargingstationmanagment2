package com.example.toshiba.chargingstationmanagment;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.bluetooth.BluetoothAdapter;
import android.widget.Button;
import android.widget.Switch;

public class station_connect extends AppCompatActivity {
    private static final String TAG="bluetooth_activity";
    BluetoothAdapter mBluetoothAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_connect);
        Button stw=(Button)findViewById(R.id.switch2);
        mBluetoothAdapter= BluetoothAdapter.getDefaultAdapter();
        stw.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                enableDisableBT();
            }
        });
    }
public void enableDisableBT(){
        if(mBluetoothAdapter == null){
            Log.d(TAG, "enableDisableBT: Does not have BT capabilities");
        }
        if (!mBluetoothAdapter.isEnabled()){
            Intent enableBTIntent=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivity(enableBTIntent);

            IntentFilter BTIntent= new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
            registerReceiver(mBroadcastReciver,BTIntent);
        }
        if (mBluetoothAdapter.isEnabled()){
            mBluetoothAdapter.disable();
            IntentFilter BTIntent= new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
            registerReceiver(mBroadcastReciver,BTIntent);

        }

}
private final BroadcastReceiver mBroadcastReciver=new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action=intent.getAction();
        if(BluetoothDevice.ACTION_FOUND.equals(action)){
            BluetoothDevice device=intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
        }
    }
 };
}
