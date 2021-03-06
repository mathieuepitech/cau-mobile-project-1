package project.mobile.cau.sanchez.mathieu.mybmw;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class SplashScreenActivity extends AppCompatActivity {

    private View mContentView;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.activity_splash_screen );

        mContentView = findViewById( R.id.fullscreen_content );
    }

    @Override
    protected void onStart() {
        super.onStart();

        hide();

        Handler handler = new Handler();
        handler.postDelayed( new Runnable() {
            @Override
            public void run() {
                startActivity( new Intent( SplashScreenActivity.this, MainActivity.class ) );
                finish();
            }
        }, 2500 );
    }

    private void hide() {
        ActionBar actionBar = getSupportActionBar();
        if ( actionBar != null ) {
            actionBar.hide();
        }

        mContentView.setSystemUiVisibility( View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION );
    }

}
