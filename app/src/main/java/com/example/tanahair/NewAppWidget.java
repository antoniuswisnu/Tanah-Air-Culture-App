package com.example.tanahair;

import static androidx.camera.core.CameraX.getContext;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.TextView;
import androidx.viewbinding.BuildConfig;
import java.text.DateFormat;
import java.util.Date;

public class NewAppWidget extends AppWidgetProvider {

    TextView tvDate;
    private static final String mSharedFile = BuildConfig.LIBRARY_PACKAGE_NAME;
    private static final String COUNT_KEY = "count";
    private SensorManager sensorManager;
    private Sensor temperatureSensor;
    private int temperatureTextView;


    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);

        SharedPreferences pref = context.getSharedPreferences(mSharedFile, 0);
        int count = pref.getInt(COUNT_KEY+appWidgetId, 0);
        count++;

        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(COUNT_KEY+appWidgetId, count);
        editor.apply();

        String currentTime = DateFormat.getDateInstance(DateFormat.FULL).format(new Date());
        views.setTextViewText(R.id.date_widget, currentTime);

        Intent intentUpdate = new Intent(context, NewAppWidget.class);
        intentUpdate.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);

        int [] idsArray = new int[] {appWidgetId};
        intentUpdate.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, idsArray);

        appWidgetManager.updateAppWidget(appWidgetId, views);

    };


    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);

        // Intent Weather
        Intent weatherIntent = new Intent(context, WeatherActivity.class);
        PendingIntent weatherPendingIntent = PendingIntent.getActivity(context, 0, weatherIntent, 0);
        remoteViews.setOnClickPendingIntent(R.id.btnWeather, weatherPendingIntent);

        // Intent Map
        Intent mapIntent = new Intent(context, MapsActivity.class);
        PendingIntent mapPendingIntent = PendingIntent.getActivity(context, 0, mapIntent, 0);
        remoteViews.setOnClickPendingIntent(R.id.btnMap, mapPendingIntent);


        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);

        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }

        // Get a reference to the temperature TextView in your widget layout
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
//            temperatureTextView = remoteViews.getViewId();
//        }

        // Create a new instance of the SensorManager class
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);

        // Get a reference to the temperature sensor
        temperatureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);

        // Register a listener to receive temperature updates
        sensorManager.registerListener(sensorEventListener, temperatureSensor, SensorManager.SENSOR_DELAY_NORMAL);

        // Update the widget's UI with the initial temperature value
//        updateTemperatureTextView(getTemperature());

    }
    private float getTemperature() {
        // TODO: Implement code to obtain temperature from sensor
        return 0.0f;
    }

    private void updateTemperatureTextView(float temperature, Context context) {
        // Update the TextView in the widget layout with the new temperature value
//        temperatureTextView.setText(String.format("%.1f\u00B0C", temperature));
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
        views.setTextViewText(R.id.temperatureTextView, "%.1f\u00B0C");

    }

    private final SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            // Get the new temperature value from the sensor event
            float temperature = event.values[0];

            // Update the widget's UI with the new temperature value
//            updateTemperatureTextView(temperature);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // TODO: Implement this method if needed
        }
    };

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created

    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}