package com.example.gobsyatsmusic2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button play, pause, stop;
    MediaPlayer mp;
    int pauseCurrentPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = (Button) findViewById(R.id.btn_play);
        pause = (Button) findViewById(R.id.btn_pause);
        stop = (Button) findViewById(R.id.btn_stop);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);

    }

    @Override
    public void onClick (View view){
        switch(view.getId()){
            case R.id.btn_play:
                if(mp == null) {
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.music1);
                    mp.start();}

                    else if(!mp.isPlaying()){
                        mp.seekTo(pauseCurrentPosition);
                        mp.start();
                    }

                break;


            case R.id.btn_pause:
                if(mp!=null){
                    mp.pause();
                    pauseCurrentPosition = mp.getCurrentPosition();
                }

                break;

            case R.id.btn_stop:
                if(mp!=null) {
                    mp.stop();
                    mp = null;
                }
                break;

        }

    }
}
