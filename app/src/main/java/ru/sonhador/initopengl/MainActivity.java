package ru.sonhador.initopengl;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "INITGL";
    private GLSurfaceView glSurfaceView;
    private boolean renderSet = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        final ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
        final boolean supportES2 = configurationInfo.reqGlEsVersion >= 0x20000;

        Log.d(TAG, "onCreate: " + supportES2);

        glSurfaceView = new GLSurfaceView(this);



        setContentView(R.layout.activity_main);
    }
}
