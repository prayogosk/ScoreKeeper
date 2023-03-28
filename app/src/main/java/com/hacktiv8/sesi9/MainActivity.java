package com.hacktiv8.sesi9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mScore1;
    private int mScore2;

    private TextView mScoreText1;
    private TextView mScoreText2;

    private static final String STATE_SCORE1 = "STATE_SCORE1";
    private static final String STATE_SCORE2 = "STATE_SCORE2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreText1 = findViewById(R.id.score_1);
        mScoreText2 = findViewById(R.id.score_2);

        if(savedInstanceState != null){
            mScore1 = savedInstanceState.getInt(STATE_SCORE1);
            mScore2 = savedInstanceState.getInt(STATE_SCORE2);

            mScoreText1.setText(String.valueOf(mScore1));
            mScoreText2.setText(String.valueOf(mScore2));

        }
    }

    public void decreaseScore(View view) {
        int viewId = view.getId();
        switch (viewId){
            case R.id.decreaseTeam1:
                //TO DO
                mScore1--;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.decreaseTeam2:
                //TO DO
                mScore2--;
                mScoreText2.setText(String.valueOf(mScore2));
                break;
        }

    }

    public void increaseScore(View view) {
        int viewId = view.getId();
        switch (viewId){
            case R.id.increaseTeam1:
                //TO DO
                mScore1++;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.increaseTeam2:
                //TO DO
                mScore2++;
                mScoreText2.setText(String.valueOf(mScore2));
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        int nightMode = AppCompatDelegate.getDefaultNightMode();

        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.day_mode).setTitle(R.string.day_mode);
        }else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId() == R.id.night_mode){
            //TO DO
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else if(item.getItemId() == R.id.day_mode){
            //TO DDO
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        return true;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
        outState.putInt(STATE_SCORE1, mScore1);
        outState.putInt(STATE_SCORE2, mScore2);
        super.onSaveInstanceState(outState);
    }

}