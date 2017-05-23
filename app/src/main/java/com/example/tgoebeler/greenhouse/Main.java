package com.example.tgoebeler.greenhouse;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

public class Main extends AppCompatActivity {

    // TextViews for the humidity and temperature and Strings which are their content
    private final String TAG = this.getClass().getName();
    private TextView tempText;
    private String insideTemp;
    private String outsideTemp;

    private static TextView humidTxt;
    private static String insideHumid;
    private static String outsideHumid;

    private Button webcamButton;

    // test variable for getting JSON data
    public static String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.i(TAG, "onCreate");

        // sets the temperature and humidity TextViews
        tempText = (TextView) findViewById(R.id.tempText);
        setTempTxt("70", "60");

        humidTxt = (TextView) findViewById(R.id.humidityText);
        setHumidTxt("50", "40");

        // OnClickListener for the webcam button, which opens the video
        webcamButton = (Button) findViewById(R.id.webcamButton);
        webcamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=qzMQza8xZCc")));
                Log.i("Video", "Video Playing....");

            }
        });

        Database database = new Database();
        database.execute("http://ephemeraltech.com/demo/android_tutorial20.php");
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

    // sets the text of the temperature TextView
    // the first string is for the inside temperature, the second string is the outside temperature
    public void setTempTxt(String newInside, String newOutside) {
        insideTemp = newInside;
        outsideTemp = newOutside;
        tempText.setText("Inside Temperature: "+ insideTemp + "\nOutside Temperature: " + outsideTemp);
    }

    // sets the text of the humidity TextView
    // the first string is for the inside humidity, the second string is the outside humidity
    public static void setHumidTxt(String newInside, String newOutside) {
        insideHumid = newInside;
        outsideHumid = newOutside;
        humidTxt.setText("Inside Humidity: "+ insideHumid + "\nOutside Humidity: " + outsideHumid);
    }
}
