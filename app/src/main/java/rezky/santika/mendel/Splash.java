package rezky.santika.mendel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {

    Handler handler;
    MediaPlayer mySong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mySong=MediaPlayer.create(Splash.this,R.raw.soundsplash);
        mySong.start();
        Thread timer=new Thread(){
            public void run(){
                try{
                    sleep(5500);
                }catch(InterruptedException e){
                    e.printStackTrace();

                }finally{
                    nextActivity();


                }}} ;

        timer.start();
    }

    public void nextActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}