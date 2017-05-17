package com.example.tgoebeler.greenhouse;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.VideoView;

public class Main extends AppCompatActivity {

    private final String TAG = this.getClass().getName();
    private TextView tempText;
    private int insideTemp;
    private int outsideTemp;

    private TextView humidTxt;
    private int insideHumid;
    private int outsideHumid;

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.i(TAG, "onCreate");

        tempText = (TextView) findViewById(R.id.tempText);
        setTempTxt(70, 60);

        humidTxt = (TextView) findViewById(R.id.humidityText);
        setHumidTxt(50, 40);

        videoView = (VideoView) findViewById(R.id.videoView);
        //setContentView(videoView);
        videoView.setVideoURI(Uri.parse("https://www.youtube.com/watch?v=qzMQza8xZCc"));
        videoView.start();
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

    public void setTempTxt(int newInside, int newOutside) {
        insideTemp = newInside;
        outsideTemp = newOutside;
        tempText.setText("Inside Temperature: "+ insideTemp + "\nOutside Temperature: " + outsideTemp);
    }

    public void setHumidTxt(int newInside, int newOutside) {
        insideHumid = newInside;
        outsideHumid = newOutside;
        humidTxt.setText("Inside Humidity: "+ insideHumid + "\nOutside Humidity: " + outsideHumid);
    }
}
