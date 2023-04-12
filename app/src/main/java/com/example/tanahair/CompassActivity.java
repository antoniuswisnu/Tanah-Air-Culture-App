package com.example.tanahair;

import androidx.appcompat.app.AppCompatActivity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.hardware.SensorEvent;
import android.widget.ImageView;
import android.widget.TextView;
import android.hardware.SensorEventListener;
import android.os.Bundle;

public class CompassActivity extends AppCompatActivity implements SensorEventListener{

    private SensorManager SensorManager;
    private ImageView compassimage;
    private float DegreeStart = 0f;
    TextView DegreeTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compass);

        compassimage = findViewById(R.id.compass_image);
        DegreeTV = findViewById(R.id.DegreeTV);
        SensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // code for system's orientation sensor registered listeners
        SensorManager.registerListener(this, SensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float degree = Math.round(sensorEvent.values[0]);
        DegreeTV.setText("Heading: " + degree + " degrees");
        // rotation animation - reverse turn degree degrees
        RotateAnimation ra = new RotateAnimation(
                DegreeStart,
                -degree,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        ra.setFillAfter(true);
        ra.setDuration(210);
        compassimage.startAnimation(ra);
        DegreeStart = -degree;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}