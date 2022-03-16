package com.example.playeractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MediaPlayer player;
    Integer[]list ={R.raw.srivalli,R.raw.oo,R.raw.eyy};
    ImageView play,pause,pre,next;
    int currentposition = 0;
    int length = list.length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        pre = findViewById(R.id.pre);
        next = findViewById(R.id.next);
        pre.setOnClickListener(MainActivity.this);
        next.setOnClickListener(MainActivity.this);
        pause.setOnClickListener(MainActivity.this);
        play.setOnClickListener(MainActivity.this);
        player = MediaPlayer.create(MainActivity.this,list[0]);
//        player = MediaPlayer.create(MainActivity.this,R.raw.Oo);
//        player = MediaPlayer.create(MainActivity.this,R.raw.Eyy);
        player.start();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.play:
                player.start();
                break;
            case R.id.pause:
                player.pause();
                break;
            case R.id.pre:
                player.start();
                callprevious();
                break;
            case R.id.next:
                callnext();
                break;
        }
    }

    private void callnext() {
        player.stop();
        if (currentposition ==list.length-1){
            player = MediaPlayer.create(MainActivity.this,list[0]);
            currentposition = 0;
        }else {
            player = MediaPlayer.create(MainActivity.this,list[currentposition+1]);
            currentposition++;
        }
        player.start();
    }

    private void callprevious() {
        player.stop();
        switch (currentposition){
            case 0:
            player = MediaPlayer.create(MainActivity.this, list[list.length-1]);
            currentposition = list.length-1;
            break;
            default:
                player = MediaPlayer.create(MainActivity.this, list[currentposition-1]);
                currentposition--;
        }
        player.start();


    }
}