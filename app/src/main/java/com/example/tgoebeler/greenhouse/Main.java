package com.example.tgoebeler.greenhouse;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Main extends AppCompatActivity {

    private final String TAG = this.getClass().getName();
    private TextView tempTxt;
    private int insideTemp;
    private int outsideTemp;

    private TextView humidTxt;
    private int insideHumid;
    private int outsideHumid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.i(TAG, "onCreate");

        insideTemp = 70;
        outsideTemp = 60;

        tempTxt = (TextView) findViewById(R.id.textView);
        tempTxt.setText("Inside Temperature: " + insideTemp + "\nOutside Temperature: " + outsideTemp);

        insideHumid = 50;
        outsideHumid = 40;

        humidTxt = (TextView) findViewById(R.id.textView2);
        humidTxt.setText("Inside Humidity: "+ insideHumid + "\nOutside Humidity: " + outsideHumid);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
