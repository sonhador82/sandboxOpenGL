package ru.sonhador.initopengl;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
        if (supportES2) {
            // request OpenGl context
            glSurfaceView.setEGLContextClientVersion(2);
            glSurfaceView.setRenderer(new CustomRenderer(this));
            renderSet = true;
        } else {
            Toast.makeText(this, "Device dont support OpenGL ES2", Toast.LENGTH_SHORT).show();
        }
        setContentView(glSurfaceView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (renderSet){
            glSurfaceView.onPause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(renderSet){
            glSurfaceView.onResume();
        }
    }
}
