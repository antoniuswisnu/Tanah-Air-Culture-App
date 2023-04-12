package com.example.tanahair;

import androidx.appcompat.app.AppCompatActivity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class WeatherActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private TextView mTextLightSensor;
    private TextView mTextTemperatureSensor;
    private TextView mTextHumiditySensor;

    private Sensor mlightSensor;
    private Sensor mTemperatureSensor;
    private Sensor mHumiditySensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensorList = mSensorManager.getSensorList(Sensor.TYPE_ALL);

        StringBuilder sensorText = new StringBuilder();

        for (Sensor currentSensor : sensorList) {
//            Log.d("Sensor: ", currentSensor.getName());
            sensorText.append(currentSensor.getName()).
                    append(System.getProperty("line.separator"));
        }

        mTextLightSensor = findViewById(R.id.light);
        mTextHumiditySensor = findViewById(R.id.humidity);
        mTextTemperatureSensor = findViewById(R.id.temperature);

        mlightSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        mHumiditySensor = mSensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        mTemperatureSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);

        Date myDate = new Date();
        String formatDate = DateFormat.getDateInstance().format(myDate);
        TextView tvDate = findViewById(R.id.tvDate);
        tvDate.setText(formatDate);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mHumiditySensor != null){
            mSensorManager.registerListener(this, mHumiditySensor, SensorManager.SENSOR_DELAY_NORMAL);
        }

        if(mTemperatureSensor != null){
            mSensorManager.registerListener(this, mTemperatureSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (mlightSensor != null){
            mSensorManager.registerListener(this, mlightSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        float result = sensorEvent.values[0];

        switch (type){
            case Sensor.TYPE_AMBIENT_TEMPERATURE:
                mTextTemperatureSensor.setText(getResources().getString(R.string.temperature_text, result));
                break;
            case Sensor.TYPE_LIGHT:
                mTextLightSensor.setText(getResources().getString(R.string.light_text, result));
                break;
            case Sensor.TYPE_RELATIVE_HUMIDITY:
                mTextHumiditySensor.setText(getResources().getString(R.string.humidity_text, result));
                break;
            default:
                break;
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}