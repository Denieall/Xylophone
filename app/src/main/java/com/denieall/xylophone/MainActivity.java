package com.denieall.xylophone;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // Constants
    private final int NR_OF_SIMULTANEOUS_SOUNDS = 7;
    private final float LEFT_VOLUME = 1.0f;
    private final float RIGHT_VOLUME = 1.0f;
    private final int NO_LOOP = 0;
    private final int PRIORITY = 0;
    private final float NORMAL_PLAY_RATE = 1.0f;

    // 1. Add member Variables
    private SoundPool mSoundPool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. Create new SoundPool

//        Short way
//        mSoundPool = new SoundPool.Builder().setMaxStreams(NR_OF_SIMULTANEOUS_SOUNDS)
//                .setAudioAttributes(new AudioAttributes.Builder().setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
//                                                                 .setUsage(AudioAttributes.USAGE_GAME).build())
//                .build();

        SoundPool.Builder sb = new SoundPool.Builder();
        sb.setMaxStreams(NR_OF_SIMULTANEOUS_SOUNDS);

        AudioAttributes.Builder ab = new AudioAttributes.Builder();
        ab.setUsage(AudioAttributes.USAGE_MEDIA);
        ab.setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION);
        AudioAttributes aa = ab.build();

        sb.setAudioAttributes(aa);

        mSoundPool = sb.build();

    }

    // 4. Add the play methods triggered by the buttons
    public void playSound(View v) {

        if (v.getId() == R.id.c_key) {

            mSoundPool.load(getApplicationContext(), R.raw.note1_c, 1);

        } else if (v.getId() == R.id.d_key) {

            mSoundPool.load(getApplicationContext(), R.raw.note2_d, 1);

        } else if (v.getId() == R.id.e_key) {

            mSoundPool.load(getApplicationContext(), R.raw.note3_e, 1);

        } else if (v.getId() == R.id.f_key) {

            mSoundPool.load(getApplicationContext(), R.raw.note4_f, 1);

        } else if (v.getId() == R.id.g_key) {

            mSoundPool.load(getApplicationContext(), R.raw.note5_g, 1);

        } else if (v.getId() == R.id.a_key) {

            mSoundPool.load(getApplicationContext(), R.raw.note6_a, 1);

        } else if (v.getId() == R.id.b_key) {

            mSoundPool.load(getApplicationContext(), R.raw.note7_b, 1);

        }

        // Set onloadcomplete listener for soundpool object
        mSoundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int id, int status) {
                soundPool.play(id, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
            }
        });

    }
}
